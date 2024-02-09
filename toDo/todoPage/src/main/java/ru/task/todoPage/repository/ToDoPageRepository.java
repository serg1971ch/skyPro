package ru.task.todoPage.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.task.todoPage.model.Task;

@Repository
public interface ToDoPageRepository extends ListCrudRepository<Task, Integer> {
}
