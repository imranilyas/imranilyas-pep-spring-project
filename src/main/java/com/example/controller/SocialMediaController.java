package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 * 
 * Put methods with endpoints, but those will need to be adjusted
 */
@RestController
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        return accountService.registerHandler(account);
    }

    @PostMapping("/login")
    public Account login() {
        return null;
    }

    @PostMapping("/messages")
    public Message createMessage() {
        return null;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return null;
    }

    @GetMapping("/messages/{message_id}")
    public Message getMessageGivenMessageId() {
        return null;
    }

    @DeleteMapping("/messages/{message_id}")
    public void deleteMessageByMessageId() {

    }

    @PatchMapping("/messages/{message_id}")
    public Message updateMessageByMessageId() {
        return null;
    }

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagesByAccountId() {
        return null;
    }
}
