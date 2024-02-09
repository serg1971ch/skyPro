package ru.task.todoPage.repository;

import java.util.*;
public interface ToDoDao <T>{
    List<T> list();

    void create(T t);

    Optional<T> get(int id);

    void update(T t, int id);

    void delete(int id);
}
