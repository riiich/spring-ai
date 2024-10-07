package com.example.Spring.Boot.AI.Integration.controller;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class ChatController {
    private final OpenAiChatModel chatModel;

    @Autowired
    public ChatController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("")
    public String defaultRoot() {
        return "Endpoint to generate AI joke reached!";
    }

    @GetMapping("/generate")
    public Map generate(@RequestParam(value="message", defaultValue="Tell me a joke") String message) {
        System.out.println("GET request to generate a joke!");

        return Map.of("generation", this.chatModel.call(message));
    }

    @GetMapping("/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value="message", defaultValue="Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));

        return this.chatModel.stream(prompt);
    }
}
