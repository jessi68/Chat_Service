package com.example.demo.controller;


import com.example.demo.domain.ChatForm;
import com.example.demo.service.MessagesService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessagesService messagesService;

    public HomeController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping()
    public String getHomePage(ChatForm messageForm, Model model) {
        model.addAttribute("greetings", this.messagesService.getChatMessages());
        return "home";
    }

    @PostMapping()
    public String addMessage(ChatForm messageForm, Model model) {
        messagesService.addMessage(messageForm);
        model.addAttribute("greetings", messagesService.getChatMessages());
        messageForm.setMessageText("");
        return "home";
    }

}
