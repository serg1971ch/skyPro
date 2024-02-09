package ru.task.todoPage.service;

import ru.task.todoPage.model.Task;

import java.util.List;
import java.util.Optional;

public interface ToDoPageService {
     void saveTask(Task task);
     List<Task> findAll();
}
