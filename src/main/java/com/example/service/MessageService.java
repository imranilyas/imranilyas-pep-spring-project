package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Message createMessageHandler() {
        return null;
    }

    public List<Message> getAllMessagesHandler() {
        return null;
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
