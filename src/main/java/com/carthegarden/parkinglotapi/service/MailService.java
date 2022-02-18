package com.carthegarden.parkinglotapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@EnableAsync
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    // TODO: 실패했을시 예외처리
    @Async
    public void sendMail(String subject, String text, String email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
        try {
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }
}
