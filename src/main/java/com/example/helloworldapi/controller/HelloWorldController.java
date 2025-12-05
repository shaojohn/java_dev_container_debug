package com.example.helloworldapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        String timeString = java.time.LocalDateTime.now().toString();
        String greeting = "Hello World! Current server time is: " + timeString;
        return greeting;
    }
}
