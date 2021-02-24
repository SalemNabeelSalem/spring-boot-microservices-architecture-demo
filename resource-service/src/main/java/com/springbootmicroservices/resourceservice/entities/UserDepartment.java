package com.springbootmicroservices.resourceservice.entities;

import com.springbootmicroservices.resourceservice.dtos.DepartmentDTO;
import com.springbootmicroservices.resourceservice.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartment {

    private UserDTO user;

    private DepartmentDTO department;
}
