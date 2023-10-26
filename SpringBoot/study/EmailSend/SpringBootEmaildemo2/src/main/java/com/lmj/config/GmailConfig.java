package com.lmj.config;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;


@Configuration
public class GmailConfig {

//    @Value("${gmail.clientId}")
//    private String clientId;
//
//    @Value("${gmail.clientSecret}")
//    private String clientSecret;
//
//    @Value("${gmail.refreshToken}")
//    private String refreshToken;
//
//    @Value("${gmail.username}")
//    private String username;
//
//    @Bean
//    public JavaMailSender javaMailSender() throws GeneralSecurityException, IOException {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername(username);
//        mailSender.setPassword("oauth2_token");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//
//        mailSender.setJavaMailProperties(props);
//        mailSender.setSession(mailSession());
//
//        return mailSender;
//    }
//
//    private Session mailSession() throws GeneralSecurityException, IOException {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//
//        Credential credential = authorize();
//
//        Session session = Session.getDefaultInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, "");
//            }
//        });
//
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
//        props.put("mail.smtp.sasl.enable", "true");
//        props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
//        props.put("mail.smtp.sasl.authorizationid", username);
//        props.put("mail.smtp.sasl.realm", "https://mail.google.com");
//
//        return session;
//    }
//
//    private Credential authorize() throws GeneralSecurityException, IOException {
//        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
//
//        GoogleCredential credential = new GoogleCredential.Builder()
//                .setTransport(httpTransport)
//                .setJsonFactory(jsonFactory)
//                .setClientSecrets(clientId, clientSecret)
//                .build();
//
//        credential.setAccessToken(credential.getAccessToken());
//        credential.setRefreshToken(refreshToken);
//
//        return credential;
//    }
//
//    public void sendEmail(String to, String subject, String body) throws MessagingException, GeneralSecurityException, IOException {
//        JavaMailSender mailSender = javaMailSender();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//
//        mailSender.send(message);
//    }
}