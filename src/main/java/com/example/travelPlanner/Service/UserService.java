package com.example.travelPlanner.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelPlanner.Model.User;
import com.example.travelPlanner.Repository.UserRepository;

@Service
public class UserService {
	
	//uses the repository and exposes methods to the controller
	
	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoder.encode(hashedPassword)); // hash the plain password string here
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getByUserName(String userName) {
    	 System.out.println("Searching for user: " + userName);
    	 User user = userRepository.findByUsername(userName);
    	System.out.println("Found user: " + user);
    	return user;
    }
}
