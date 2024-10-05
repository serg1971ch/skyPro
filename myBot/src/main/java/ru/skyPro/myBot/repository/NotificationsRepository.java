package ru.skyPro.myBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skyPro.myBot.model.Notification;

import java.time.LocalDateTime;
import java.util.Collection;

public interface NotificationsRepository extends JpaRepository<Notification, Integer> {
    Collection<Notification> findByNotificationDate(LocalDateTime now);
}
