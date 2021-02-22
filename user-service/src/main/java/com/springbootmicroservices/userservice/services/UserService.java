package com.springbootmicroservices.userservice.services;

import com.springbootmicroservices.userservice.dtos.UserDTO;
import com.springbootmicroservices.userservice.entities.User;
import com.springbootmicroservices.userservice.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUpdate(UserDTO inputUser) {

        try {

            User user = new User();

            user.setName(inputUser.getName());

            user.setAge(Integer.parseInt(inputUser.getAge()));

            return modelMapper.map(userRepository.save(user), UserDTO.class);

        } catch (Exception ex) {

            LOGGER.warn("#=# Exception in UserService -> saveUpdate(): " + ex);
        }

        return null;
    }

    public UserDTO getUserById(Long id) {

        return null;
    }

    public List<UserDTO> getUserByName(String name) {

        return null;
    }
}