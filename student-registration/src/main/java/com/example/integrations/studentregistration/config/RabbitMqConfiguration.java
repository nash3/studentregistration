package com.example.integrations.studentregistration.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.integrations.studentregistration.common.Constants.QueueName.STUDENT_REGISTRATION_QUEUE;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Queue queue()
    {
        return  new Queue(STUDENT_REGISTRATION_QUEUE, true);
    }
}
