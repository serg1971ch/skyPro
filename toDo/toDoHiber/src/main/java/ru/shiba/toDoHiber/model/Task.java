package ru.shiba.toDoHiber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_task")
    private String nameTask;
    @Column(name = "desctiption_task")
    private String descriptionTask;
    @Enumerated
    private State state;
    @Enumerated
    private Importance importance;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "message_id")
    private List<Message> messageList;

    public Task(String name, String description, State state, Importance importance, List<Message> messageList) {
        this.nameTask = name;
        this.descriptionTask = description;
        this.state = state;
        this.importance = importance;
        this.messageList = messageList;
    }

    public  Task() {

    }



    public long getId() {
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
