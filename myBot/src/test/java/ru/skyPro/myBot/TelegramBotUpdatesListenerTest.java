package ru.skyPro.myBot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import ru.skyPro.myBot.listener.TelegramBotUpdatesListener;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TelegramBotUpdatesListenerTest {

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private Logger logger;

    @InjectMocks
    private TelegramBotUpdatesListener updatesListener;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUpdates() {
        // Arrange
        Update update = mock(Update.class);
        when(update.message().getChatId()).thenReturn(123456789L);
        when(update.message().getText()).thenReturn("Hello");

        List<Update> updates = Collections.singletonList(update);

        // Act
        int result = updatesListener.process(updates);

        // Assert
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(logger).info(captor.capture(), Optional.ofNullable(any()));
        assertEquals("Processing update: {}", captor.getValue());

        assertEquals(UpdatesListener.CONFIRMED_UPDATES_ALL, result);
    }
}

