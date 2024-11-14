package com.example.demo.service;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UpdateUserDetails;
import com.example.demo.bo.UserResponse;
import com.example.demo.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    UserResponse updateProfile(UpdateUserDetails request);
    UserResponse profileDetails();
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    void deleteUserById(Long id);
}
