package com.example.demo.service;

import com.example.demo.domain.ChatForm;
import com.example.demo.domain.ChatMessage;

import java.util.List;

public class MessagesService {
    private List<ChatMessage> chatMessages;

    public void addMessage(ChatForm chatForm) {
        String messageText = chatForm.getMessageText();
        String message = chatForm.getMessageType().decorateFrom(messageText);
        ChatMessage chatMessage = new ChatMessage(message, chatForm.getUserName());
        this.chatMessages.add(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return this.chatMessages;
    }

}
