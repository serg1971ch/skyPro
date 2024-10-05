package ru.skyPro.myBot.configuration;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.*;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;

@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new SendMessage("Hello World!", "Hello World!"));
        return bot;
    }
}
