package com.spring_rasa_chatbot.chatbot.controller;

import com.spring_rasa_chatbot.chatbot.service.RasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    @Autowired
    private RasaService rasaService;

    @PostMapping
    public ResponseEntity<String> chatWithBot(@RequestBody Map<String, String> payload) {
        String message = payload.get("message");
        String response = rasaService.sendMessageToRasa(message);
        return ResponseEntity.ok(response);
    }
}
