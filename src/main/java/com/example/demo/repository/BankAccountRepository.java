package com.example.demo.repository;

import com.example.demo.entity.BankAccountEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.util.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {
    List<BankAccountEntity> findByUserId(Long userId);
}
