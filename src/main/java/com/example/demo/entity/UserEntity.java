package com.example.demo.entity;

import com.example.demo.util.Roles;
import com.example.demo.util.Status;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String name;

//    @Enumerated(EnumType.STRING)
//    private Status status;

    // using username as email so we deleted email
    @Column(name="user_name", nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false)
    private String address;


    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public UserEntity() {}

//    @OneToMany(mappedBy = "bank_account_id")
//    private List<BankAccountEntity> bankAccount = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }


    //    public List<BankAccountEntity> getBankAccount() {
//        return bankAccount;
//    }
//
//    public void setBankAccount(List<BankAccountEntity> bankAccount) {
//        this.bankAccount = bankAccount;
//    }
}
