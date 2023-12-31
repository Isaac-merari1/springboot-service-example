//package com.merari.springbootdemo.repository;
//
//import com.merari.springbootdemo.entity.Department;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
////@SpringBootTest
////@Transactional
//class DepartmentRepositoryTest {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//    @BeforeEach
//    void setUp() {
//        Department departmentMock = Department.builder()
//                .departmentName("IT")
//                .departmentAddress("Accra")
//                .departmentCode("IT-01")
//                .departmentID(1L)
//                .build();
//        entityManager.persist(departmentMock);
//    }
//
//    @Test
//    @Disabled
//    void testFindById() {
//        Department department = departmentRepository.findById(1L).get();
//        assertEquals(department.getDepartmentName(), "IT");
//    }
//    @Test
//    void findByDepartmentName() {
//    }
//
//    @Test
//    void findByDepartmentNameIgnoreCase() {
//    }
//}