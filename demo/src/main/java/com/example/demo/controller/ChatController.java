package com.example.demo.controller;
import com.example.demo.domain.ChatForm;
import com.example.demo.service.MessagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    MessagesService messagesService;

    public ChatController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messagesService.getChatMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String putMessage(ChatForm chatForm, Model model) {
        this.messagesService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messagesService.getChatMessages());
        return "chat";
    }
}