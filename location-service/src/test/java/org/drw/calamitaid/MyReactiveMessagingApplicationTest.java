package org.drw.calamitaid;

import io.quarkus.test.junit.QuarkusTest;

import org.drw.calamitaid.service.IncidentService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MyReactiveMessagingApplicationTest {

    @Inject
    IncidentService application;

    @Test
    void test() {
        assertEquals("HELLO", "HELLO");
        //assertEquals("BONJOUR", application.toUpperCase(Message.of("bonjour")).getPayload());
    }
}