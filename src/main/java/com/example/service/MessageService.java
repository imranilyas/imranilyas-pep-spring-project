package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<Message> createMessageHandler(Message message) {
        // Check message is valid
        String text = message.getMessage_text().trim();
        if(text.isEmpty() || text.length() >= 255) {
            return ResponseEntity.status(400).build();
        } else {
            Message savedMessage = messageRepository.save(message);
            return ResponseEntity.status(200).body(savedMessage);
        }
    }

    public ResponseEntity<List<Message>> getAllMessagesHandler() {
        List<Message> list = messageRepository.findAll();
        return ResponseEntity.status(200).body(list);
    }

    public ResponseEntity<Message> getMessageByMessageIdHandler(Integer id) {
        Message message = messageRepository.findById(id).orElse(null);
        return ResponseEntity.status(200).body(message);
    }

    public ResponseEntity<Integer> deleteMessageByMessageIdHandler(Integer id) {
        Message message = messageRepository.findById(id).orElse(null);
        if(message == null) {
            return ResponseEntity.status(200).build();
        }

        messageRepository.deleteById(id);

        boolean exists = messageRepository.existsById(id);
        if(exists) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(200).body(1);
        }
    }

    public ResponseEntity<Integer> updateMessageHandler(Integer message_id, Message message) {
        Message original = messageRepository.findById(message_id).orElse(null);
        String text = message.getMessage_text().trim();

        if(text.isEmpty() || text.length() >= 255 || original == null) {
            return ResponseEntity.status(400).build();
        }
        original.setMessage_text(message.getMessage_text());   
        messageRepository.save(original);     

        return ResponseEntity.status(200).body(1);
    }

    public ResponseEntity<List<Message>> getMessagesByAccountHandler(Integer account_id) {
        List<Message> list = messageRepository.findMessagesByPosted_By(account_id);
        return ResponseEntity.status(200).body(list);
    }

}