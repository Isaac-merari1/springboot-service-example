package com.merari.springbootdemo.services;

import com.merari.springbootdemo.controller.DepartmentController;
import com.merari.springbootdemo.entity.Department;
import com.merari.springbootdemo.exceptions.DepartmentNotFoundException;
import com.merari.springbootdemo.repository.DepartmentRepository;
import com.merari.springbootdemo.request.DepartmentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Accra")
                .departmentCode("IT-01")
                .departmentID(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @DisplayName("Get department by name")
    @Test
    void testGetDepartmentByName() throws DepartmentNotFoundException {
        DepartmentRequest departmentRequest = new DepartmentRequest("IT","address","IT-01");
        Department department = departmentService.getDepartmentByName(departmentRequest.getDepartmentName()).getBody();

        assertEquals(departmentRequest.getDepartmentName(), department.getDepartmentName());
    }

    @Test
    void getAllDepartment() {
    }

    @Test
    void getDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartmentById() {
    }

    @Test
    void getDepartmentByName() {
    }
}