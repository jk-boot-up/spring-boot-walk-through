package com.jk.explore.boot.echo.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class EchoServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name= "EchoService", fallbackMethod = "echoFallback")
    public String echoMessage(String message) {
        String responseMessage;
        responseMessage = restTemplate.getForObject("http://localhost:9090/rest/v1/echo/{message}", String.class, message);
        if(message.contains("JK")) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Causing fallback by throwing runtime exception");
        }
        return responseMessage;
    }

    public String echoFallback(String message, Throwable e) {
        System.out.println("message for fallback: "+ message);
        System.out.println("fallback called due to exception: "+e);
        return "echo service call failed. Hence fallback called with default message: DUMMY, message: "+ message;
    }





}
