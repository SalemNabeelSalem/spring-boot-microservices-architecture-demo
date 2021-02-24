package com.springbootmicroservices.resourceservice.controllers;

import com.springbootmicroservices.resourceservice.dtos.UserDTO;
import com.springbootmicroservices.resourceservice.entities.Department;
import com.springbootmicroservices.resourceservice.entities.UserDepartment;
import com.springbootmicroservices.resourceservice.feignservices.DepartmentServiceFeign;
import com.springbootmicroservices.resourceservice.feignservices.UserServiceFeign;
import com.springbootmicroservices.resourceservice.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResourceController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private DepartmentServiceFeign departmentServiceFeign;

    @Autowired
    private ResourceService resourceService;

    @GetMapping(value = "/res_user_get_by_id/{id}")
    public UserDepartment getUserById(@PathVariable Long id) {

        return resourceService.getUserById(id);
    }

    @GetMapping(value = "/res_get_user_by_name")
    public List<UserDTO> getUserByName(@RequestParam("name") String name) {

        return userServiceFeign.getUserByName(name);
    }

    @GetMapping(value = "/res_get_department_by_id/{id}")
    public Department getDepartmentById(@PathVariable Long id) {

        return departmentServiceFeign.getDepartmentById(id);
    }
}