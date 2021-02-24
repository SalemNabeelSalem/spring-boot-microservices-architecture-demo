package com.springbootmicroservices.departmentservice.controllers;

import com.springbootmicroservices.departmentservice.entities.Department;
import com.springbootmicroservices.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save_new_department")
    public Department saveNewDepartment(@RequestBody Department InputDepartment) {

        return departmentService.saveNewDepartment(InputDepartment);
    }

    @GetMapping("/get_department_by_id/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {

        return departmentService.getDepartmentById(id);
    }
}