package com.lmj.mail_send.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.*;

public class EmailJavaxUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailJavaxUtil.class);

    // 发件人smtp邮箱服务地址
    private static final String senderSmtpHost = "smtp.qq.com";
    // 发件人邮箱地址
    private static final String senderEmail = "2863039606@qq.com";
    // smtp邮箱授权码
    private static final String senderPassword = "nmypwpdgufigdghb";
    // 端口
    private static final String senderSmtpPort = "465";

   public static void sendEmail(String subject, String content,boolean contentIsHtml, String fromMailPersonalName,
                                  String toMail, String ccMail, String bccMail, List<String> fileNames)
            throws GeneralSecurityException, UnsupportedEncodingException, MessagingException {

        // 设置参数
        Properties properties = System.getProperties();
        // smtp服务地址
        properties.put("mail.smtp.host",senderSmtpHost);
        // smtp服务端口
        properties.put("mail.smtp.port", senderSmtpPort);
        // 开启验证
        properties.put("mail.smtp.auth","true");
        // 开启TLS加密
        properties.put("mail.smtp.starttls.enable","true");
        // 是否启用socketFactory，默认为true
        properties.put("mail.smtp.socketFactory.fallback", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 建立会话，利用内部类将邮箱授权给jvm
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        // 设置为true可以在控制台打印发送过程，生产环境关闭
        session.setDebug(true);
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 通过MimeMessageHelper设置正文和附件，否则会导致两者显示不全
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
        //设置收件人,to为收件人,cc为抄送,bcc为密送
        if (StringUtils.isEmpty(toMail)) {
            logger.error("邮件收件人为空");
            return;
        }
        //设置发件人
        helper.setFrom(new InternetAddress(senderEmail, fromMailPersonalName));
        helper.setTo(InternetAddress.parse(toMail, false));
        if (!StringUtils.isEmpty(ccMail)) {
            helper.setCc(InternetAddress.parse(ccMail, false));
        }
        if (!StringUtils.isEmpty(bccMail)) {
            helper.setBcc(InternetAddress.parse(bccMail, false));
        }
        // 设置邮件主题
        helper.setSubject(subject);
        //设置邮件正文内容
        helper.setText(content,contentIsHtml);
        //设置发送的日期
        helper.setSentDate(new Date());
        // 设置附件（注意这里的fileName必须是服务器本地文件名，不能是远程文件链接）
        if(!CollectionUtils.isEmpty(fileNames)){
            for (String fileName : fileNames) {
                FileDataSource fileDataSource = new FileDataSource(fileName);
                helper.addAttachment(fileDataSource.getName(),fileDataSource);
            }
        }
        //调用Transport的send方法去发送邮件
        Transport.send(message);

    }

}