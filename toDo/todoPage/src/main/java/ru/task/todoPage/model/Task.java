package ru.task.todoPage.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.*;
@NoArgsConstructor
@Table("TASKS")
public class Task {
    @Id
    private int id;

    private String nameTask;

    private String descriptionTask;

    private State state;

    private Importance importance;

    @MappedCollection(idColumn="MESSAGE_ID")
    private List<Message> messageList;

    public Task(String name, String description, State state, Importance importance, List<Message> messageList) {
        this.nameTask = name;
        this.descriptionTask = description;
        this.state = state;
        this.importance = importance;
        this.messageList = messageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
