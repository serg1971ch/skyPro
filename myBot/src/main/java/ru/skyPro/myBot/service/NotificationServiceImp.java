package ru.skyPro.myBot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skyPro.myBot.exceptions.IncorrectMessageException;
import ru.skyPro.myBot.model.Notification;
import ru.skyPro.myBot.repository.NotificationsRepository;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class NotificationServiceImp  implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImp.class);
    private static final String REGEX_MSG = "[0-9\\.\\:s]{16}(\\s)([\\W+]+)";

    private final NotificationsRepository repository;
    private final TelegramBot bot;

    public NotificationServiceImp(NotificationsRepository repository, TelegramBot bot) {
        this.repository = repository;
        this.bot = bot;
    }

    @Override
    public void sendNotificationMessage() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Collection<Notification> notifications = repository.findByNotificationDate(now);
        notifications.forEach(task -> {
            sendMessage(task);
            task.setAsSent();
            logger.info("Notification was sent {} ", task);
        });
        repository.saveAll(notifications);
        logger.info("Notifications saved");
    }

    @Override
    public long scheduleNotification(Notification notification, long chatId) {
        return 0;
    }


    @Override
    public Optional<Notification> parseMessage(String message) throws IncorrectMessageException {
        Notification notification = null;

        Pattern pattern = Pattern.compile(REGEX_MSG);
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String messageToSave = matcher.group(3);
            LocalDateTime messageLocalDateTime = LocalDateTime.parse(messageToSave, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            if(messageLocalDateTime.isAfter(LocalDateTime.now())) {
                notification = new Notification(messageToSave, messageLocalDateTime);
                logger.info("Saving {} to db", notification);
                repository.save(notification);
            }else {
                logger.info("Not saving {} to db", notification);
                throw new IncorrectMessageException("Not saving message");
            }
        }
        return Optional.ofNullable(notification);
    }

    @Override
    public void sendMessage(long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        bot.execute(sendMessage);
        logger.info("message was sent: {}", message);
    }

    @Override
    public void sendMessage(Notification notification) {
        sendMessage(notification.getChatId(), notification.getMessage());
    }
}
