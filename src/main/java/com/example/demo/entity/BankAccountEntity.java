package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public BankAccountEntity(UserEntity user) {
        this.balance = 0.0;
        this.user = user;
    }

    public BankAccountEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
