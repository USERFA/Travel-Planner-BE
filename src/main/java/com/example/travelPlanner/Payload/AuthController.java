package com.example.travelPlanner.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelPlanner.Model.User;
import com.example.travelPlanner.Service.UserService;

import JwtSecurity.JwtUtil;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    	logger.info("Login request received for username:" + request.getUserName());
    	User currentUser = userService.getByUserName(request.getUserName());
    	System.out.println("The user is: " +currentUser);
    	if(currentUser == null) {
    		System.out.println("Wrong credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");

    		
    	}else {
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(request.getPassword(), currentUser.getPassword())) {
                System.out.println("Invalid username or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

            }else {
            	System.out.println("It matches");
            }

            String token = jwtUtil.generateToken(currentUser.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
    	}
    }

}
