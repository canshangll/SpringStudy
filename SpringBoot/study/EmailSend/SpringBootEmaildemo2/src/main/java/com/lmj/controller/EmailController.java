package com.lmj.controller;

import com.lmj.Service.EmailService;
import com.lmj.Utils.Email.GmailUtils;
import com.lmj.properties.GmailPropertie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @projectName: SpringBootEmaildemo2
 * @package: com.lmj.controller
 * @className: EmailController
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/19 14:33
 * @version: 1.0
 */
@RestController
@RequestMapping
public class EmailController {

    @Resource
    private GmailPropertie gmailPropertie;
    @Resource
    private EmailService emailService;
    @GetMapping("/sendGmail")
    public void sendGmail(){
//        GmailUtils.build(gmailPropertie).send("验证码","1111","2863039606@qq.com");
//        emailService.sendEmail("2863039606@qq.com","Test Email","Hello");
    }

    @GetMapping("/send")
    public String sendEmail() throws MessagingException {
        String to = "2863039606@qq.com";
        String subject = "Test Email";
        String text = "This is a test email.";

        emailService.sendEmail(to, subject, text);
        return "Email sent successfully!";
    }
}
