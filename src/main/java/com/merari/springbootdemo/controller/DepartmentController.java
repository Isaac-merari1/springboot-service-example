package com.merari.springbootdemo.controller;

import com.merari.springbootdemo.entity.Department;
import com.merari.springbootdemo.exceptions.DepartmentNotFoundException;
import com.merari.springbootdemo.request.DepartmentRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.merari.springbootdemo.services.DepartmentService;

import java.util.List;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Value("${welcome.message}")
    private String welcomeMessage;
    @GetMapping("/hello")
    public String sayHello(){
        return welcomeMessage;
    }
    @PostMapping("/department")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody DepartmentRequest request) throws DepartmentNotFoundException {
        LOGGER.info("inside addDepartment of departmentService");
       return  departmentService.addDepartment(request);
    }
    @GetMapping("/department/all")
    public List<Department> getAllDepartment() throws DepartmentNotFoundException {
        return departmentService.getAllDepartment();
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }
    @DeleteMapping("/department/delete/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.deleteDepartmentById(id);
    }
    @PutMapping("/department/update/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id, @RequestBody DepartmentRequest request) throws DepartmentNotFoundException {
        return departmentService.updateDepartmentById(id, request);
    }
    @GetMapping("/department/name/{name}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String name) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(name);
    }
}
