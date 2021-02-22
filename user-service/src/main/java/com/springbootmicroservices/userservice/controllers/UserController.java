package com.springbootmicroservices.userservice.controllers;

import com.springbootmicroservices.userservice.dtos.UserDTO;
import com.springbootmicroservices.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUpdate")
    public UserDTO saveUpdate(@RequestBody UserDTO inputUser) {

        return userService.saveUpdate(inputUser);
    }

    @GetMapping(value = "/getById/{id}")
    public UserDTO getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping(value = "/getByName")
    public List<UserDTO> getUserByName(@Param("name") String name) {

        return userService.getUserByName(name);
    }
}