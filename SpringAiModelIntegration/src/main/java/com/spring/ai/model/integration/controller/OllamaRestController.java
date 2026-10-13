package com.spring.ai.model.integration.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OllamaRestController {

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @GetMapping("/ollamaAiResponse")
    public ResponseEntity<String> openAiResponse(@RequestParam String askQuestion) {

        try {

            String prompt = """
                    You are a helpful AI assistant.
                    Always respond in English only.
                    
                    User Question:
                    """ + askQuestion;

            String response = ollamaChatModel.call(prompt);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}