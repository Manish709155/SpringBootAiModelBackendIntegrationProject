package com.spring.ai.model.integration.controller;


import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AnthropicRestController {

    @Autowired
    AnthropicChatModel anthropicChatModel;

    @GetMapping("/anthropicResponse")
    public ResponseEntity<String> openAiResponse(@RequestParam String askQuestion){

        try {
            return  new ResponseEntity<>(anthropicChatModel.call(askQuestion), HttpStatus.OK);
        }
        catch (RuntimeException e){

            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
