package com.lmj;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import static com.lmj.mail_send.utils.EmailJavaxUtil.sendEmail;

@SpringBootTest
public class test {

    /**
     * javax.mail 实现邮件发送
     */
    @Test
    public void test1(){
        String fileName = "E:\\work\\java\\SpringBoot\\study\\EmailSend\\SpringBootEmailSendDemo1\\src\\main\\resources\\text.txt";

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
        try {
            sendEmail("测试邮件1",html,true,"55555","a2863039606@163.com",null,null, Collections.singletonList(fileName));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
