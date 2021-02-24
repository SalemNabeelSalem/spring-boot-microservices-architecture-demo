package com.springbootmicroservices.userservice.controllers;

import com.springbootmicroservices.userservice.dtos.UserDTO;
import com.springbootmicroservices.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save_new_user")
    public UserDTO saveNewUser(@RequestBody UserDTO inputUser) {

        return userService.saveNewUser(inputUser);
    }

    @GetMapping(value = "/get_user_by_id/{id}")
    public UserDTO getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping(value = "/get_user_by_name")
    public List<UserDTO> getUserByName(@RequestParam("name") String name) {

        return userService.getUserByName(name);
    }
}