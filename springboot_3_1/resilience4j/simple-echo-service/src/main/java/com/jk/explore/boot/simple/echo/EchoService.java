package com.jk.explore.boot.simple.echo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

@Component
public class EchoService {

    private static final String DEFAULT_WELCOME_MESSAGE = "Welcome to Echo Service.";

    public EchoService() {
        System.out.println("EchoService constructor called");
    }

    public String getWelcomeMessage(String message) {

        if(message == null || message.trim().isEmpty()) {
            return DEFAULT_WELCOME_MESSAGE;
        }
        if(message.contains("500")) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Http Status 500: Something wrong");
        }

        return "Welcome to Echo service. Message: " + message;
    }

}
