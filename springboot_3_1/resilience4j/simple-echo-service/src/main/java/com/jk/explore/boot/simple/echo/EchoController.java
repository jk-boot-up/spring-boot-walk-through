package com.jk.explore.boot.simple.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/")
public class EchoController {

    private final EchoService echoService;

    @Autowired
    public EchoController(EchoService echoService) {
        this.echoService = echoService;
        System.out.println("EchoController constructor called");
    }

    @GetMapping("echo/{message}")
    public String echoMessage(@PathVariable String message) {
        System.out.println("echoMessage called from EchoController. message:" +message);
        return echoService.getWelcomeMessage(message);
    }

}
