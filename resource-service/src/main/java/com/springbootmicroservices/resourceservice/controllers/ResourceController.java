package com.springbootmicroservices.resourceservice.controllers;

import com.springbootmicroservices.resourceservice.dtos.UserDTO;
import com.springbootmicroservices.resourceservice.feignservices.UserServiceFeign;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResourceController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping(value = "/res_user_get_by_id/{id}")
    public UserDTO getUserById(@PathVariable Long id) {

        return userServiceFeign.getUserById(id);
    }

    @GetMapping(value = "res_get_user_by_name")
    public List<UserDTO> getUserByName(@Param("name") String name) {

        return userServiceFeign.getUserByName(name);
    }
}