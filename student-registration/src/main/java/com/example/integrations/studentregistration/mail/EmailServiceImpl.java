package com.example.integrations.studentregistration.mail;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.example.integrations.studentregistration.common.Constants.QueueName.STUDENT_REGISTRATION_QUEUE;

@Service
@RabbitListener(queues = STUDENT_REGISTRATION_QUEUE)
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @RabbitHandler
    public void onReceive(Email email) {
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(email.getSubject());
        mailMessage.setFrom(email.getFrom());
        mailMessage.setTo(email.getTo());

        if (email.getCc().length > 0) {
            mailMessage.setCc(email.getCc());
        }
        mailMessage.setText(email.getMessage());

        mailSender.send(mailMessage);
    }
}
