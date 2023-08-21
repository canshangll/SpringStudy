package com.lmj.mail_send.controller;

import com.lmj.mail_send.utils.EmailCommonsUtil;
import com.lmj.mail_send.utils.EmailSpringUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@RestController
public class EmailController {

    private final EmailCommonsUtil emailCommonsUtil;

    private final EmailSpringUtil emailSpringUtil;

    public EmailController(EmailCommonsUtil emailCommonsUtil, EmailSpringUtil emailSpringUtil) {
        this.emailCommonsUtil = emailCommonsUtil;
        this.emailSpringUtil = emailSpringUtil;
    }

    @GetMapping("sendCommonEmail")
    public void sendCommonEmail(){
        String subject = "这是一个测试标题";
        String html = "<h1>统计数据如下所示：</h1>" +
                "<table border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>月度销售额</th>\n" +
                "    <th>年度销售额</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>10000</td>\n" +
                "    <td>2000000</td>\n" +
                "  </tr>\n" +
                "</table>";
        String[] toMail = new String[]{"a2863039606@163.com"};
        String[] ccMail = new String[]{"2863039606@qq.com"};
        File file = new File("E:\\work\\java\\SpringBoot\\study\\EmailSend\\SpringBootEmailSendDemo1\\src\\main\\resources\\text.txt");
        try {
            emailCommonsUtil.sendEmail(subject,html,true,toMail,ccMail,null,new File[]{file});
        } catch (EmailException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("sendSpringEmail")
    public void sendSpringEmail(){
        String subject = "这是一个测试标题";
        String html = "<h1>统计数据如下所示：</h1>" +
                "<table border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>月度销售额</th>\n" +
                "    <th>年度销售额</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>10000</td>\n" +
                "    <td>2000000</td>\n" +
                "  </tr>\n" +
                "</table>";
        String toMail = "a2863039606@163.com";
        String ccMail = "2863039606@qq.com";
        String fileName = "E:\\work\\java\\SpringBoot\\study\\EmailSend\\SpringBootEmailSendDemo1\\src\\main\\resources\\text.txt";
        try {
            emailSpringUtil.sendEmail(subject,html,true,"邮件提醒系统",toMail,ccMail,null, Arrays.asList(fileName));
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
