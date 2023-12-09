package ru.task.todoPage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("MESSAGES")
public class Message {
    @Id
    private int messageId;

    private String description;

    @MappedCollection(idColumn = "userId")
    private User user;

    public Message(int idTask, String descriptionName, User user) {
        this.messageId = idTask;
        this.description = descriptionName;
        this.user = user;
    }

    public int getIdTask() {
        return messageId;
    }

    public void setIdTask(int messageId) {
        this.messageId = messageId;
    }

    public String getDescriptionName() {
        return description;
    }

    public void setDescriptionName(String descriptionName) {
        this.description = descriptionName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
