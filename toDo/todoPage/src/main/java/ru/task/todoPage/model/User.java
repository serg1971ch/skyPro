package ru.task.todoPage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class User {
    @Id
    private int userId;

    private String nameUser;

    private Boolean executeRole;
    @PersistenceCreator
    public User(int id, String nameUser, Boolean executorRole) {
        this.userId = id;
        this.nameUser = nameUser;
        this.executeRole = executorRole;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Boolean getExecutorRole() {
        return executeRole;
    }

    public void setExecutorRole(Boolean executorRole) {
        this.executeRole = executorRole;
    }
}
