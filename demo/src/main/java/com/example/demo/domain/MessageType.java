package com.example.demo.domain;

import org.springframework.stereotype.Component;

import java.util.function.Function;


public enum MessageType {
    SAY(0, "Say", (message) -> (message)),
    SHOUT(1, "Shout", (message) -> (message.toUpperCase())),
    Whisper(2, "Whisper", (message) -> (message.toLowerCase()));

    private final int number;
    private final String type;
    private final Function<String, String> decorator;


    MessageType(int number, String type, Function<String, String> decorator) {
        this.number = number;
        this.type = type;
        this.decorator = decorator;
    }

    public String decorateFrom(String message) {
        return this.decorator.apply(message);
    }
}
