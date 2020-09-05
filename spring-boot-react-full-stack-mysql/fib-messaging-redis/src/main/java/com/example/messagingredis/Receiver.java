package com.example.messagingredis;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    @Autowired
    FibService fibService;

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        fibService.calculateAndStore(Integer.parseInt(message));
        //counter.incrementAndGet();

    }

    public int getCount() {
        return counter.get();
    }
}
