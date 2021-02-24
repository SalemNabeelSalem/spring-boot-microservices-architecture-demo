package com.springbootmicroservices.departmentservice.services;

import com.springbootmicroservices.departmentservice.entities.Department;
import com.springbootmicroservices.departmentservice.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveNewDepartment(Department department) {

        log.info("#=# DepartmentService -> saveDepartment().");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {

        log.info("#=# DepartmentService -> getDepartmentById().");
        return departmentRepository.findById(id).orElse(new Department());
    }
}