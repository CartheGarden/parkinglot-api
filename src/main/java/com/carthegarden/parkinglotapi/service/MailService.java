package com.carthegarden.parkinglotapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

@Service
@EnableAsync
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    // TODO: 실패했을시 예외처리
    @Async
    public void sendMail(String subject, String email, String name, Long usageId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");

        final Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("usageId", usageId);

        String htmlContent = templateEngine.process("usage_email", context);

        try {
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    @Async
    public void sendMail(String subject, String email, String name, Integer charge) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");

        final Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("charge", charge);

        String htmlContent = templateEngine.process("charge_email", context);

        try {
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }
}
