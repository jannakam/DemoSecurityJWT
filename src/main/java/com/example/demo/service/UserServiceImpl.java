package com.example.demo.service;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UpdateUserDetails;
import com.example.demo.bo.UserResponse;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.Roles;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        RoleEntity newRole = new RoleEntity(Roles.valueOf(request.getRole()));
        newRole = roleRepository.save(newRole);
        userEntity.setRole(newRole);
        userEntity.setAddress(request.getAddress());
        userEntity.setPhoneNumber(request.getPhoneNumber());
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getUsername());
        return response;
    }

    @Override
    public UserResponse updateProfile(UpdateUserDetails request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        existingUser.setUsername(request.getUsername());

        existingUser.setAddress(request.getAddress());
        existingUser.setPhoneNumber(request.getPhoneNumber());
        existingUser = userRepository.save(existingUser);
        UserResponse response = new UserResponse(existingUser.getId(), existingUser.getUsername());
        return response;
    }

    @Override
    public UserResponse profileDetails() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserResponse response = new UserResponse(existingUser.getId(), existingUser.getUsername());
        return response;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        UserEntity myUser = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Id not found"));
        return myUser;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
