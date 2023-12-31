package com.merari.springbootdemo.repository;

import com.merari.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
