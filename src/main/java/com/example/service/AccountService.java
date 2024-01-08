package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Account> loginHandler(Account account) {
        Account login = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if(login == null) {
            return ResponseEntity.status(401).build();
        } else {
            return ResponseEntity.status(200).body(login);
        }
    }

    public ResponseEntity<Account> registerHandler(Account account) {
        if(account.getUsername().trim().isEmpty() || account.getPassword().length() < 4) {
            return ResponseEntity.status(400).build();
        }
        boolean accountExists = accountRepository.existsByUsername(account.getUsername());
        if(accountExists) {
            return ResponseEntity.status(409).build();
        } else {
            Account newAccount = accountRepository.save(account);
            return ResponseEntity.status(200).body(newAccount);
        }
    }
}
