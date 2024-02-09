package ru.shiba.toDoHiber.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.shiba.toDoHiber.model.Task;

import java.util.List;
@Service
public interface ToDoPageService {
     void saveTask(Task task);
     List<Task> findAll();
}
