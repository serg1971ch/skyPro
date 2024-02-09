package ru.shiba.toDoHiber.repository;

import org.springframework.stereotype.Repository;
import ru.shiba.toDoHiber.model.Task;

import java.util.List;
import java.util.Optional;
@Repository
public interface ToDoDao <T>{
    void saveTask(Task task);

    List<Task> findAll();

    List<Task> findByName(String name);

    Optional<Task> findById(long id);
    void updateNameById(long id, String name);
    void deleteById(long id);
}
