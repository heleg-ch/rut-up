package ru.home.preparado.service;

import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final String ADDRESS;

    private final MailSender mailSender;


    public MailService(MailSender mailSender, Environment env) {
        this.mailSender = mailSender;
        this.ADDRESS = env.getProperty("spring.mail.username");
    }

    public void sendMessage(String email, String message) {
        final SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setTo(email);
        simpleMail.setFrom(ADDRESS);
        simpleMail.setSubject("Код активации");
        simpleMail.setText(message);
        mailSender.send(simpleMail);
    }
}
