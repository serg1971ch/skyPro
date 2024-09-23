package ru.skyPro.myBot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.skyPro.myBot.exceptions.IncorrectMessageException;
import ru.skyPro.myBot.model.Notification;
import ru.skyPro.myBot.service.NotificationService;

//import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

import static ru.skyPro.myBot.CommandConst.*;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final NotificationService notificationService;
    private final TelegramBot telegramBot;

    public TelegramBotUpdatesListener(NotificationService notificationService, TelegramBot telegramBot) {
        this.notificationService = notificationService;
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void sendNotificationMessage() {
        notificationService.sendNotificationMessage();
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            // Process your updates here
            Message message = update.message();
            if (message.text().startsWith(START_CMD)) {
                logger.info(START_CMD + ' ' + "{}", LocalDateTime.now());
                notificationService.sendMessage(getChatId(message), WELCOME + message.from().firstName() + " ");
                notificationService.sendMessage(getChatId(message), INVALID_MSG);
            } else {
                try {
                    notificationService
                            .parseMessage(message.text())
                            .ifPresentOrElse(
                                    task -> scheduledNotification(getChatId(message), task),
                                    () -> notificationService.sendMessage(getChatId(message), INVALID_MSG)
                            );
                } catch (IncorrectMessageException exception) {
                    notificationService.sendMessage(getChatId(message), "Сообщение не соответствует выбранному формату");
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void scheduledNotification(long chatId, Notification task) {
        notificationService.scheduleNotification(task, chatId);
        notificationService.sendMessage(chatId, "The task has  " + task.getMessage() + " created");
    }

    private long getChatId(Message message) {
        return message.chat().id();
    }
}
