package DTO;


import java.util.List;

import com.example.travelPlanner.Model.Reservation;

import jakarta.validation.constraints.*;

public class UserDTO {

    private long ID;
    @NotBlank(message = "Username is required!")
    private String firstName;
    private String lastName;
    @Email(message="Email should be valid!")
    private String email;
    private String username;
    private String role = "USER"; // default role
    //@Size(min = 6, message = "Password must be at least 6 characters")
    //    private String password;

    private List<Reservation> reservations;

    //Constructors
    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = firstName + " " + lastName;
    }

    // Getters and setters
    public String getUsername() {
        return username;//firstName+" "+lastName;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

