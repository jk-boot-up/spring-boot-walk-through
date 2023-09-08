package com.jk.explore.boot.echo.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.Assert.notNull;

@RestController
@RequestMapping("/rest/api/caller/v1/")
public class EchoServiceDelegateController {

    private final EchoServiceCaller echoServiceCaller;

    @Autowired
    public EchoServiceDelegateController(EchoServiceCaller echoServiceCaller) {
        notNull(echoServiceCaller, "echoServiceCaller can't be null");
        this.echoServiceCaller = echoServiceCaller;
        System.out.println("ServiceDelegateController constructor called");
    }
    @RequestMapping("echo/{message}")
    public String getMessageFromService(@PathVariable String message) {
        return echoServiceCaller.echoMessage(message);
    }



}
