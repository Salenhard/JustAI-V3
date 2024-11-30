package com.example.demo.service;

public interface MessageSenderService<T> {
    void send(T message);
}
