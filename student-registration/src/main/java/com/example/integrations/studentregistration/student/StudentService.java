package com.example.integrations.studentregistration.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> findByEmail(String email);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void save(Student student);

    boolean isStudentExist(Student student);

}
