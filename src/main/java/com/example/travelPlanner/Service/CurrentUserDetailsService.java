package com.example.travelPlanner.Service;

 import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.travelPlanner.Model.User;

@Service
public class CurrentUserDetailsService {
//	service used to load user info for Spring Security during authentication
	
	private final UserService userService;

    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (User) org.springframework.security.core.userdetails.User
            .withUsername(user.getUserName())
            .password(user.getPassword()) // password must be hashed!
            .authorities("USER") // simple role
            .build();
    }

}
