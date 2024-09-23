package ru.skyPro.myBot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(name = "chat_id")
    private int chatId;
    private String message;
    @Column(name = "notification_date")
    private LocalDateTime notificationDate;

    @Override
    public String toString() {
        return "Notification: " +
                "id = " + id +
                ", chatId = " + chatId +
                ", message = '" + message + '\'' +
                ", notificationDate = " + notificationDate +
                ", notificationSent = " + notificationSent +
                ", status = " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return chatId == that.chatId && Objects.equals(id, that.id) && Objects.equals(message, that.message) && Objects.equals(notificationDate, that.notificationDate) && Objects.equals(notificationSent, that.notificationSent) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, message, notificationDate, notificationSent, status);
    }

    @Column(name = "notification_sent")
    private LocalDateTime notificationSent;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private NotificationStatus status = NotificationStatus.SCHEDULED;

    public Notification(String message, LocalDateTime notificationDate) {
        this.message = message;
        this.notificationDate = notificationDate;
    }

    public void setAsSent() {
        this.notificationSent = LocalDateTime.now();
        this.status = NotificationStatus.SENT;
    }
}
