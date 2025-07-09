package com.example.travelPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travelPlanner.Model.User;
import com.example.travelPlanner.Repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//(REST API, handles Http requests and calls the service layer

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @PostMapping
    public User getByUserName(String username) {
        return userRepository.findByUserName(username);
    }

}
