package com.example.travelPlanner.Payload;

//DTO : DATA TRANSFER OBJECT
public class LoginRequest {

	private String userName;
    private String password;

    // Default constructor (important for JSON deserialization)
    public LoginRequest() {}

    public String getUserName() { return userName; }
    public void setUserName(String username) { this.userName = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
