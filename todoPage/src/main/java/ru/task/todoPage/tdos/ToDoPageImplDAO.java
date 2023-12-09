package ru.task.todoPage.tdos;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.task.todoPage.model.Task;
import ru.task.todoPage.model.User;

import java.util.List;

@Data
@Repository
public class ToDoPageImplDAO {
    private List<Task> tasks;
    private User userNonExecuter;
    private User userExecuter;

    public ToDoPageImplDAO(List<Task> tasks) {
        this.tasks = tasks;
        this.userNonExecuter = getUserNonExecuter();
        this.userExecuter = userNonExecuter;
    }
}
