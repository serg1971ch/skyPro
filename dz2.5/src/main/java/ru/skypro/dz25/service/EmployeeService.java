package ru.skypro.dz25.service;

import ru.skypro.dz25.model.Employee;

import java.util.List;

public interface EmployeeService {
    void add(String firstName, String secondName);

    void remove(String firstName, String secondName);

    String findEmployee(String firstName, String secondName);

    List<Employee> findAll();
}
