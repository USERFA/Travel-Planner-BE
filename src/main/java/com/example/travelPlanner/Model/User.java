package com.example.travelPlanner.Model;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import JwtSecurity.SecurePassword;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppUser") // to rename the db name to userApp since User is a keyword

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long ID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String  password; 
	private String role = "USER"; // default role
	
	//1 user has n reservations
    @OneToMany(mappedBy = "user")// name of the User field in the Reservation entity.
    private List<Reservation> reservations;

//Constructors
	public User() {
	}

	public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = firstName + " " + lastName;
    }

// Getters and setters
	public String getUserName() {
		return firstName+" "+lastName;
	}
	
	public void setUserName(String firstname,String lastname) {
		this.username = firstname+" "+lastname;		
	}
	
	public Long getId() {
		return ID;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setfirstName(String name) {
		this.firstName = name;
	}

	public void setlastName(String name) {
		this.lastName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
