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

    public Department saveDepartment(Department department) {

        log.info("Inside saveDepartment method of DepartmentService.");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {

        log.info("Inside findDepartmentById method of DepartmentService.");
        return departmentRepository.findById(departmentId).orElse(new Department());
    }
}