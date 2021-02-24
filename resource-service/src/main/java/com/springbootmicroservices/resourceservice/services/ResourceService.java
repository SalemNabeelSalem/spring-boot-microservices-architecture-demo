package com.springbootmicroservices.resourceservice.services;

import com.springbootmicroservices.resourceservice.dtos.DepartmentDTO;
import com.springbootmicroservices.resourceservice.dtos.UserDTO;
import com.springbootmicroservices.resourceservice.entities.UserDepartment;
import com.springbootmicroservices.resourceservice.feignservices.DepartmentServiceFeign;
import com.springbootmicroservices.resourceservice.feignservices.UserServiceFeign;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private DepartmentServiceFeign departmentServiceFeign;

    public UserDepartment getUserById(Long id) {

        UserDTO user = userServiceFeign.getUserById(id);

        DepartmentDTO department = modelMapper.map(
            departmentServiceFeign.getDepartmentById(user.getDepartmentId()), DepartmentDTO.class
        );

        UserDepartment userDepartment = new UserDepartment(user, department);

        return userDepartment;
    }
}