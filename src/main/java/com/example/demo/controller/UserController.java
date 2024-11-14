package com.example.demo.controller;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UpdateUserDetails;
import com.example.demo.bo.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hi, you are an authenticated user";
    }

    @PutMapping("/update-profile")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserDetails request) {
        UserResponse response = userService.updateProfile(request);

        // Check if the response is not null (indicating a successful creation)
        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> profileDetails() {
        UserResponse response = userService.profileDetails();

        // Check if the response is not null (indicating a successful creation)
        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
