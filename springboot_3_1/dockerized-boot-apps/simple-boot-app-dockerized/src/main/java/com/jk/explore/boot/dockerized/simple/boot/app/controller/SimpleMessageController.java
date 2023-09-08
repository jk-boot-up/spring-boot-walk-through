package com.jk.explore.boot.dockerized.simple.boot.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1")
public class SimpleMessageController {

    @GetMapping("/simple/echo/{message}")
    public String getMessage(@PathVariable("message") String message) {
        return "Welcome to Spring Boot. Echoing the message: "+ message;
    }
}
