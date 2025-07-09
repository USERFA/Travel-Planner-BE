package com.example.travelPlanner.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travelPlanner.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data will implement this automatically
	
	//JPA : handles DB crud operations without the need to write SQL
		//used for login, find by username || password
	 	 User findByUsername(String username);
}