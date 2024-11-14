package com.example.demo.bo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserDetails {
    private String username;
    private String address;
    private String phoneNumber;

    public UpdateUserDetails () {
        // Default constructor
    }

    public UpdateUserDetails(String username, String address, String phoneNumber) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
