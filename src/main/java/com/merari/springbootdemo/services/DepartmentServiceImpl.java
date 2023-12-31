package com.merari.springbootdemo.services;

import com.merari.springbootdemo.entity.Department;
import com.merari.springbootdemo.exceptions.DepartmentNotFoundException;
import com.merari.springbootdemo.request.DepartmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.merari.springbootdemo.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public ResponseEntity<Department> addDepartment(DepartmentRequest request) throws DepartmentNotFoundException {
        try{
            Department department = new Department();
            department.setDepartmentCode(request.getDepartmentCode());
            department.setDepartmentAddress(request.getDepartmentAddress());
            department.setDepartmentName(request.getDepartmentName());
            return ResponseEntity.ok(departmentRepository.save(department));
        } catch (Exception e){
            throw new DepartmentNotFoundException("Department not available ", e);

        }

    }
    @Override
    public List<Department> getAllDepartment() throws DepartmentNotFoundException {
        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()) {
            throw new DepartmentNotFoundException("Department table is empty");
        }
        return departments;
    }


    @Override
    public ResponseEntity<Department> getDepartmentById(Long id) throws DepartmentNotFoundException {
        try{
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department not available"));
            return ResponseEntity.ok(department);
        } catch (Exception e){
            throw new DepartmentNotFoundException("Department not available", e);
        }
    }

    @Override
    public ResponseEntity<String> deleteDepartmentById(Long departmentID) throws DepartmentNotFoundException {
            if(departmentRepository.existsById(departmentID)){
                departmentRepository.deleteById(departmentID);
                return ResponseEntity.ok("+ id + \" is deleted !!\"");
            } else {
                throw new DepartmentNotFoundException("Department id: " + departmentID + " not found ");
            }
    }

    @Override
    public ResponseEntity<Department> updateDepartmentById(Long departmentID, DepartmentRequest request) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentID);

        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();

            if (Objects.nonNull(request.getDepartmentCode()) && !request.getDepartmentCode().isEmpty()) {
                department.setDepartmentCode(request.getDepartmentCode());
            }
            department.setDepartmentAddress(request.getDepartmentAddress());
            department.setDepartmentCode(request.getDepartmentCode());

            return ResponseEntity.ok(departmentRepository.save(department));
        } else {
            throw new DepartmentNotFoundException("Department id: " + departmentID + " not found");
        }
    }
    @Override
    public ResponseEntity<Department> getDepartmentByName(String departName) throws DepartmentNotFoundException {
        Optional<Department> department = Optional.ofNullable(departmentRepository.findByDepartmentNameIgnoreCase(departName));
        if(department.isPresent()){
            return ResponseEntity.ok(department.get());
        }
        else{
            throw new DepartmentNotFoundException("Department with name: " + departName + " not found");
        }
    }
}
