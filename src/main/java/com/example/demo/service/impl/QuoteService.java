package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    public String quote(String message) {
        return "Вы сказали: %s".formatted(message);
    }
}
