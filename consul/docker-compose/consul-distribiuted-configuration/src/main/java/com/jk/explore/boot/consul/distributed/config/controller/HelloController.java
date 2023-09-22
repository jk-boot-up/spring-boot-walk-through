package com.jk.explore.boot.consul.distributed.config.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")
    ResponseEntity<Object> welcome() {
        return ResponseEntity.of(Optional.of("Hello World"));
    }



}
