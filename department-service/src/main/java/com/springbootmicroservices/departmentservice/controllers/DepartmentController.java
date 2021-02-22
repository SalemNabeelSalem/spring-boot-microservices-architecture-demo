package com.springbootmicroservices.departmentservice.controllers;

import com.springbootmicroservices.departmentservice.entities.Department;
import com.springbootmicroservices.departmentservice.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department departmentRequest) {

        log.info("Inside saveDepartment method of DepartmentController.");
        return departmentService.saveDepartment(departmentRequest);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {

        log.info("Inside findDepartmentById method of DepartmentController.");
        return departmentService.findDepartmentById(departmentId);
    }
}