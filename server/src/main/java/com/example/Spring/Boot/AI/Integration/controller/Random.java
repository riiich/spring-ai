package com.example.Spring.Boot.AI.Integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Random {
    @GetMapping("")
    public String testRoot() {
        return "Reached the test endpoint!";
    }

    @GetMapping("/hello")
    public String getText() {
        return "Hello World!";
    }
}
