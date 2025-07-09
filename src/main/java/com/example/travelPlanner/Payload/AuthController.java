package com.example.travelPlanner.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelPlanner.Model.User;
import com.example.travelPlanner.Service.UserService;

import JwtSecurity.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:3000") // React default port
 
@RestController
@RequestMapping("/api/auth") //mapping used by the react app
public class AuthController {
	
	@Autowired
	UserService userService;
	
    @Autowired
    private JwtUtil jwtUtil;
	
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
    	logger.info("Login request received for username:::::::::::::::::::::::::::::::::::::::::::::::::: " + request.getUserName());
    	System.out.println("Received userName: " + request.getUserName());
    	System.out.println("Received password: " + request.getPassword());

    	User currentUser = userService.getByUserName(request.getUserName());
    	
    	if(currentUser == null) {
    		return "Wrong credentials";
    		
    	}else {
//    		return currentUser;
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(request.getPassword(), currentUser.getPassword())) {
                return "Invalid username or password";
            }

            String token = jwtUtil.generateToken(currentUser.getUserName());
            return token;
    	}
        // access request.getUsername() and request.getPassword()
    }

}
