package com.merari.springbootdemo.repository;

import com.merari.springbootdemo.entity.Guardian;
import com.merari.springbootdemo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .lastName("Kwame")
//                .guardianEmail("guardial@gmail.com")
                .firstName("Me")
//                .guardianNumber("12345")
//                .guardianName("Akos")
                .email("mymail@gmail.com")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentGuardian(){
        Guardian guardian = Guardian.builder()
                .email("Akos@gmail.com")
                .name("Akos")
                .number("1234456")
                .build();

        Student student = Student.builder()
                .firstName("steve")
                .email("g@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
}