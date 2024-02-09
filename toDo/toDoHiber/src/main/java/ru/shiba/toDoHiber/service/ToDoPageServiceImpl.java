package ru.shiba.toDoHiber.service;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shiba.toDoHiber.model.Task;
import ru.shiba.toDoHiber.repository.ToDoDao;

import java.util.List;
@Service
@Transactional
public class ToDoPageServiceImpl implements ToDoPageService{
    private final ToDoDao dao;
    @Autowired
    public ToDoPageServiceImpl(ToDoDao dao) {
        this.dao = dao;
    }

    @Override
    public void saveTask(Task task) {
        dao.saveTask(task);
    }

    @Override
    public List findAll() {
        return dao.findAll();
    }
}
