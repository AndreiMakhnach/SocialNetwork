package com.Dron.SocialNetwork.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {
    @KafkaListener(topics = "social-network-events", groupId = "social-network-group")
    public void consumeEvent(String message) {
        System.out.println("Consumed message: " + message);
    }
}
