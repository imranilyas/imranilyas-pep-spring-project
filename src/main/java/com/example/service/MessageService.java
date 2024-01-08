package com.example.service;

import java.util.List;
import java.util.Optional;

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

    public Message getMessageByMessageIdHandler() {
        return null;
    }

    public void deleteMessageByMessageIdHandler() {

    }

    public Message updateMessageHandler() {
        return null;
    }

    public List<Message> getMessagesByAccountHandler() {
        return null;
    }

}
