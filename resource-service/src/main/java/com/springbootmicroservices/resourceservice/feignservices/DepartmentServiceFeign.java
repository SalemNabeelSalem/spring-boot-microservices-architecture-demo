package com.springbootmicroservices.resourceservice.feignservices;

import com.springbootmicroservices.resourceservice.entities.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentServiceFeign {

    String urlPrefix = "/api/v1";

    @GetMapping(value = urlPrefix + "/get_department_by_id/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
}