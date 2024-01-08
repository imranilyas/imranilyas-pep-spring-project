package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Account> login(@RequestBody Account account) {
        return accountService.loginHandler(account);
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        ResponseEntity<Account> account = accountService.accountExists(message.getPosted_by());
        if(account.getStatusCodeValue() == 400) {
            return ResponseEntity.status(account.getStatusCodeValue()).build();
        } else {
            return messageService.createMessageHandler(message);
        }
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return messageService.getAllMessagesHandler();
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageGivenMessageId(@PathVariable("message_id") Integer id) {
        return messageService.getMessageByMessageIdHandler(id);
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageByMessageId(@PathVariable("message_id") Integer id) {
        return messageService.deleteMessageByMessageIdHandler(id);
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> updateMessageByMessageId(@PathVariable("message_id") Integer message_id, @RequestBody Message message) {
        return messageService.updateMessageHandler(message_id, message);
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getMessagesByAccountId(@PathVariable("account_id") Integer account_id) {
        return messageService.getMessagesByAccountHandler(account_id);
    }
}
