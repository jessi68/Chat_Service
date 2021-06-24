package com.example.demo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class ChatForm {
    private MessageType messageType;
    private String userName;
    private String messageText;
}
