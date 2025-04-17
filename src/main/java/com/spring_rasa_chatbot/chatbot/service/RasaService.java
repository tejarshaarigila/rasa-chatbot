package com.spring_rasa_chatbot.chatbot.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;


@Service
public class RasaService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String RASA_URL = "http://localhost:5005/webhooks/rest/webhook";

    public String sendMessageToRasa(String message) {
        Map<String, String> request = Map.of("sender", "user", "message", message);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(RASA_URL, entity, String.class);

        return extractBotReply(response.getBody());
    }

    private String extractBotReply(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            return root.get(0).get("text").asText();
        } catch (Exception e) {
            return "Sorry, I couldn't understand.";
        }
    }
}
