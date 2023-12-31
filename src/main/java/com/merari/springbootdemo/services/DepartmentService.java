package com.merari.springbootdemo.services;

import com.merari.springbootdemo.entity.Department;
import com.merari.springbootdemo.exceptions.DepartmentNotFoundException;
import com.merari.springbootdemo.request.DepartmentRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<Department> addDepartment(DepartmentRequest request) throws DepartmentNotFoundException;

    List<Department> getAllDepartment() throws DepartmentNotFoundException;

    ResponseEntity<Department> getDepartmentById(Long id) throws DepartmentNotFoundException;

    ResponseEntity<String> deleteDepartmentById(Long id) throws DepartmentNotFoundException;

    ResponseEntity<Department> updateDepartmentById(Long id, DepartmentRequest request) throws DepartmentNotFoundException;

    ResponseEntity<Department> getDepartmentByName(String name) throws DepartmentNotFoundException;

}
