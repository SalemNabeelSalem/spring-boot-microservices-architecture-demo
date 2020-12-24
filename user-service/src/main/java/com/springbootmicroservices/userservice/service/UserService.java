package com.springbootmicroservices.userservice.service;

import com.springbootmicroservices.userservice.model.User;
import com.springbootmicroservices.userservice.repository.UserRepository;
import com.springbootmicroservices.userservice.vo.Department;
import com.springbootmicroservices.userservice.vo.UserDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        log.info("Inside saveUser method of UserService");

        return userRepository.save(user);
    }

    public UserDepartment getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment method of UserService");

        UserDepartment userDepartment = new UserDepartment();

        User user = userRepository.findById(userId).orElse(new User());

        String url = "http://DEPARTMENT-SERVICE/departments/";

        Department department = restTemplate.getForObject(url + user.getDepartmentId(), Department.class);

        userDepartment.setUser(user);

        userDepartment.setDepartment(department);

        return userDepartment;
    }
}