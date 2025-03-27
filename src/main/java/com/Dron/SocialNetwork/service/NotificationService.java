package com.Dron.SocialNetwork.service;

import com.Dron.SocialNetwork.kafka.EventProducer;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final EventProducer eventProducer;

    @Async
    public void sendNotification(String userId, String message) {
        // Симуляция долгой операции
        try {
            Thread.sleep(2000);
            eventProducer.sendEvent("Уведомление для " + userId + ": " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

