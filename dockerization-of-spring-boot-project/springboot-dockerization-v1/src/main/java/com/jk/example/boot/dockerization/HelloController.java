package com.jk.example.boot.dockerization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rest/api")
public class HelloController {

    @GetMapping("/{message}")
    public ResponseEntity<String> echoMessage(@PathVariable("message") String message) {
        String responseMessage = message == null ? "Welcome to Spring Boot" : "Welcome!. echo message : " + message;
        return ResponseEntity.of(Optional.of(responseMessage));
    }

    @GetMapping
    public ResponseEntity<String> welcomeMessage() {
        String responseMessage = "Hello, Welcome to Spring Boot";
        return ResponseEntity.of(Optional.of(responseMessage));
    }

}
