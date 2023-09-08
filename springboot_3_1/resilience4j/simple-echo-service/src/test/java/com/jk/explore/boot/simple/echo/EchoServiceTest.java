package com.jk.explore.boot.simple.echo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EchoServiceTest {

    private EchoService echoService;

    @BeforeEach
    void setUp() {
        echoService = new EchoService();
    }

    @Test
    void getWelcomeMessage() {
        assertEquals("Welcome to Echo service. Message: JK", echoService.getWelcomeMessage("JK"));
    }

    @Test
    void getWelcomeMessageForNullMessage() {
        assertEquals("Welcome to Echo Service.", echoService.getWelcomeMessage(null));
    }

    @Test
    void getWelcomeMessageForEmptyMessage() {
        assertEquals("Welcome to Echo Service.", echoService.getWelcomeMessage("  "));
    }
}
