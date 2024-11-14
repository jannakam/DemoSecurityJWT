package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    // GET endpoint to retrieve all Users
    @GetMapping("/all-users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserEntity getUserById(Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }










}
