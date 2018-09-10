package com.example.integrations.studentregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudentRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentRegistrationApplication.class, args);
    }
}
