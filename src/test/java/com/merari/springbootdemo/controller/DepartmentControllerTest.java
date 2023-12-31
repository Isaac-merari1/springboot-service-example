//package com.merari.springbootdemo.controller;
//
//import com.merari.springbootdemo.entity.Department;
//import com.merari.springbootdemo.exceptions.DepartmentNotFoundException;
//import com.merari.springbootdemo.request.DepartmentRequest;
//import com.merari.springbootdemo.services.DepartmentService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebMvcTest(DepartmentController.class)
//class DepartmentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DepartmentService  departmentService;
//
//    private Department department;
//    @BeforeEach
//    void setUp() {
//        department = Department.builder()
//                .departmentName("IT")
//                .departmentAddress("Accra")
//                .departmentCode("IT-01")
//                .departmentID(1L)
//                .build();
//    }
//
//    @Test
//    @Disabled
//    void addDepartment() throws Exception {
//       DepartmentRequest inputDepartment = DepartmentRequest.builder()
//                .departmentName("IT")
//                .departmentAddress("Accra")
//                .departmentCode("IT-01")
//                .build();
//
//        Mockito.when(departmentService.addDepartment(inputDepartment))
//                .thenReturn(department);
//        mockMvc.perform(MockMvcRequestBuilders.post("/department")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\n" +
//                        "    \"departmentName\":\"IT\",\n" +
//                        "    \"departmentAddress\": \"Accra\",\n" +
//                        "    \"departmentCode\": \"IT-01\"\n" +
//                        "}"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//
//    }
//
//    @Test
//    void getAllDepartment() {
//    }
//
//    @Test
//    @Disabled
//    void getDepartmentById() throws Exception {
//        Mockito.when(departmentService.getDepartmentById(1L))
//                .thenReturn(ResponseEntity.ok(department));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.departmentNAME")
//                                .value(department.getDepartmentName()));
//    }
//
//    @Test
//    void deleteDepartmentById() {
//    }
//
//    @Test
//    void updateDepartmentById() {
//    }
//
//    @Test
//    void testGetDepartmentById() {
//    }
//}