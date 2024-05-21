package ru.skypro.dz28.service;

import ru.skypro.dz28.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String secondName);

    Employee addFullEmployee(String firstName, String secondName, int branchId, int salary);

    Employee remove(String firstName, String secondName);

    Employee findEmployee(String firstName, String secondName);

    List<Employee> findAll();
}
