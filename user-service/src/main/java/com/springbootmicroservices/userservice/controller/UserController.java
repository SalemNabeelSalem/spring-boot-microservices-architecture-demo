package com.springbootmicroservices.userservice.controller;

import com.springbootmicroservices.userservice.model.User;
import com.springbootmicroservices.userservice.service.UserService;
import com.springbootmicroservices.userservice.vo.UserDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {

        log.info("Inside saveUser method of UserController.");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDepartment getUserWithDepartment(@PathVariable("id") Long userId) {

        log.info("Inside getUserWithDepartment method of UserController.");
        return userService.getUserWithDepartment(userId);
    }
}