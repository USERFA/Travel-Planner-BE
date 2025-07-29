package com.example.travelPlanner.ServiceTesting;


import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.travelPlanner.Model.User;
import com.example.travelPlanner.Repository.UserRepository;
import com.example.travelPlanner.Service.UserService;

@SpringBootTest
public class UserServiceTesting {

	@MockBean
    private UserRepository userRepository;

	@Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = new User( "John", "Doe", "john@example.com", "pass");
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.getByID(1L);

        Assertions.assertEquals("John", found.getfirstName());
    }

    // Add more tests for create, update, delete...
}
