package com.springbootmicroservices.userservice.vo;

import com.springbootmicroservices.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartment {

    private User user;

    private Department department;
}