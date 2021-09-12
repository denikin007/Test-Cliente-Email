package com.promotion.service;

import org.springframework.mail.MailSender;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
