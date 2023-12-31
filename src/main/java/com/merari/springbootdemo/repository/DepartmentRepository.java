package com.merari.springbootdemo.repository;

import com.merari.springbootdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departName);
    Department findByDepartmentNameIgnoreCase(String departName);

}
