package ru.skyPro.myBot.service;


import org.springframework.stereotype.Service;
import ru.skyPro.myBot.exceptions.IncorrectMessageException;
import ru.skyPro.myBot.model.Notification;

import java.util.Optional;

@Service
public interface NotificationService {
    void sendNotificationMessage();

    long scheduleNotification(Notification notification, long chatId);

    Optional<Notification> parseMessage(String message) throws IncorrectMessageException;

    void sendMessage(long chatId, String message);

    void sendMessage(Notification notification);
}
