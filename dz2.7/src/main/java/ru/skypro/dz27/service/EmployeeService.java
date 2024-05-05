package ru.skypro.dz27.service;


import ru.skypro.dz27.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String secondName);

    Employee remove(String firstName, String secondName);

    Employee findEmployee(String firstName, String secondName);

    List<Employee> findAll();
}
