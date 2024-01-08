package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // For logging in
    Account findByUsernameAndPassword(String username, String password);

    // Checking if account exists
    boolean existsByUsername(String username);
}
