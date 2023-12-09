package ru.task.todoPage.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.task.todoPage.model.Task;
import ru.task.todoPage.repository.ToDoPageRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoPageServiceImpl implements ToDoPageService{
    private static final Logger log = LoggerFactory.getLogger(ToDoPageServiceImpl.class);

    private final ToDoPageRepository repository;

    @Autowired
    public ToDoPageServiceImpl(ToDoPageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveTask(Task task) {
        repository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }
}
