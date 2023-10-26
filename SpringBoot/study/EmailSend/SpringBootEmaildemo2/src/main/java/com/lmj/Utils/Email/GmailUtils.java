package com.lmj.Utils.Email;

import com.lmj.properties.GmailPropertie;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @projectName: SpringBootEmaildemo2
 * @package: com.lmj.Utils.Email
 * @className: GmailUtils
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/19 14:15
 * @version: 1.0
 */

public class GmailUtils {
//    private final GmailPropertie gmailPropertie;
//
//    public GmailUtils(GmailPropertie gmailPropertie) {
//        this.gmailPropertie = gmailPropertie;
//    }
//
//    public static GmailUtils build(GmailPropertie gmailPropertie){
//        return new GmailUtils(gmailPropertie);
//    }
//
//    /**
//     * 发送文本邮件
//     *
//     * @param subject 邮件标题
//     * @param text 内容
//     * @param to 接收人
//     */
//    public void send(String subject, String text, String... to) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(gmailPropertie.getUsername());
//        message.setText(text);
//        message.setSubject(subject);
//        message.setTo(to);
//        this.buildMailSender(gmailPropertie).send(message);
//    }
//
//    private JavaMailSender buildMailSender(GmailPropertie gmailPropertie) {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost(gmailPropertie.getHost());
//        javaMailSender.setUsername(gmailPropertie.getUsername());
//        javaMailSender.setPassword(gmailPropertie.getPassword());
//
//        javaMailSender.setDefaultEncoding(StandardCharsets.UTF_8.name());
//        if (null != gmailPropertie.getPort()) {
//            javaMailSender.setPort(gmailPropertie.getPort());
//        }
//
//        Properties properties = new Properties();
//        properties.put("mail.debug", Boolean.TRUE.equals(gmailPropertie.getDebug()));
//        properties.put("mail.smtp.auth", true);
//        properties.put("mail.smtp.connectiontimeout", 10000);
//        properties.put("mail.smtp.writetimeout", 10000);
//        properties.put("mail.smtp.starttls.enable", true);
//
//        if (Boolean.TRUE.equals(gmailPropertie.getEnableSsl())) {
//            properties.put("mail.smtp.ssl.enable", true);
//            properties.put("mail.smtp.ssl.trust", gmailPropertie.getHost());
//        }
//
//        javaMailSender.setJavaMailProperties(properties);
//        return javaMailSender;
//    }

}
