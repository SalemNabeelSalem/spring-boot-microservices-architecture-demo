package com.springbootmicroservices.resourceservice.feignservices;

import com.springbootmicroservices.resourceservice.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceFeign {

    String urlPrefix = "/api/v1/";

    @GetMapping(value = urlPrefix + "/get_by_id/{id}")
    UserDTO getUserById(@PathVariable Long id);

    @GetMapping(value = urlPrefix + "/get_by_name")
    List<UserDTO> getUserByName(@RequestParam("name") String name);
}