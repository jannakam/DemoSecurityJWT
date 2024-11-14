package com.example.demo.bo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {
//    private String name;
//    private String status;
    private String username;
    private String password;
    private String role;
    private String address;
    private String phoneNumber;

    public CreateUserRequest () {
        // Default constructor
    }

    public CreateUserRequest(String username, String password, String role, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
