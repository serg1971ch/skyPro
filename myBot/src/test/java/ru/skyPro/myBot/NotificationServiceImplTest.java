package ru.skyPro.myBot;

import com.pengrad.telegrambot.TelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.skyPro.myBot.exceptions.IncorrectMessageException;
import ru.skyPro.myBot.model.Notification;
import ru.skyPro.myBot.model.NotificationStatus;
import ru.skyPro.myBot.repository.NotificationsRepository;
import ru.skyPro.myBot.service.NotificationServiceImp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class NotificationServiceImplTest {

    @InjectMocks
    private NotificationServiceImp notificationService;

    @Mock
    private NotificationsRepository repository;

    @Mock
    private TelegramBot bot;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendNotificationMessage() {
        Notification notification = new Notification("Test message", LocalDateTime.now());
        List<Notification> notificationsList = new ArrayList<>();
        notificationsList.add(notification);

        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        when(repository.findByNotificationDate(now)).thenReturn(notificationsList);
        doNothing().when(repository).saveAll(any());

        notificationService.sendNotificationMessage();

        assertNotNull(notification.getNotificationSent());
        assertEquals(NotificationStatus.SENT, notification.getStatus());
    }

    @Test
    void testScheduleNotification() {
        Notification notification = new Notification("Test message", LocalDateTime.now());
        long chatId = 123456L;

        when(repository.save(notification)).thenReturn(notification);

        long result = notificationService.scheduleNotification(notification, chatId);

        assertEquals(notification.getId(), result);
    }

    @Test
    void testParseMessageWithValidMessage() {
        String validMessage = "01/01/2025 12:00: Test message";

        try {
            Notification notification = notificationService.parseMessage(validMessage).orElse(null);
            assertNotNull(notification);
        } catch (IncorrectMessageException e) {
            fail("Valid message threw an exception");
        }
    }

    @Test
    void testParseMessageWithInvalidMessage() {
        String invalidMessage = "01/01/2025 12:00";

        assertThrows(IncorrectMessageException.class, () -> {
            notificationService.parseMessage(invalidMessage);
        });
    }
}
