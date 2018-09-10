package com.example.integrations.studentregistration.student;

import com.example.integrations.studentregistration.mail.Email;
import com.example.integrations.studentregistration.utils.exception.DuplicateUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.integrations.studentregistration.common.Constants.QueueName.STUDENT_REGISTRATION_QUEUE;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Value("${student.registration.notification.cc}")
    private String[] cc;

    @Value("${student.registration.notification.message}")
    private String message;

    @Value("${student.registration.notification.subject}")
    private String subject;

    @Value("${student.registration.notification.from}")
    private String from;

    private final StudentService studentService;

    private final RabbitTemplate rabbitTemplate;

    public StudentController(StudentService studentService, RabbitTemplate rabbitTemplate) {
        this.studentService = studentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student)
    {
        log.info("Registering student : {}", student);
        if(studentService.isStudentExist(student))
        {
            throw new DuplicateUserException("Student with email "+student.getEmail()+" already exists!");
        }
        studentService.save(student);
        final String to = student.getEmail();
        final Email email = new Email(to, cc, message, subject, from);
        rabbitTemplate.convertAndSend(STUDENT_REGISTRATION_QUEUE, email);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents()
    {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
