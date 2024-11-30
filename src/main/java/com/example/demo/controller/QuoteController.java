package com.example.demo.controller;

import com.example.demo.dto.CallbackDto;
import com.example.demo.service.CallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callbacks")
public class QuoteController {
    private final CallbackService callbackService;

    @PostMapping
    public ResponseEntity<?> confirmation(@RequestBody CallbackDto callbackDto) {
        return ResponseEntity.ok(callbackService.handleCallback(callbackDto));
    }
}
