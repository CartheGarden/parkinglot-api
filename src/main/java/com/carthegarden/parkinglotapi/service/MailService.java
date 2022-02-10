package com.carthegarden.parkinglotapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMail(String subject, String text, String email) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject(subject);
        mail.setText(text);
        javaMailSender.send(mail);
        // TODO: 실패했을시 예외처리
    }
}
