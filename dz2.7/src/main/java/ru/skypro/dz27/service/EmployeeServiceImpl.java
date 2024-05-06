package ru.skypro.dz27.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz27.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.dz27.exceptions.EmployeeNotFoundException;
import ru.skypro.dz27.exceptions.EmployeeStorageIsFullException;
import ru.skypro.dz27.model.Employee;

import java.util.List;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int maxEmployee = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String employeeFirstName, String employeeSecondName) {
        String key = buildKey(employeeFirstName, employeeSecondName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        } else if (employees.size() > maxEmployee) {
            throw new EmployeeStorageIsFullException("Вы превысили лимит сотрудников в компании");
        }
        Employee employee = new Employee(employeeFirstName, employeeSecondName);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String employeeFirstName, String employeeSecondName) {
        String key = buildKey(employeeFirstName, employeeSecondName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String employeeFirstName, String employeeSecondName) {
        String key = buildKey(employeeFirstName, employeeSecondName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);
    }

    private String buildKey(String employeeFirstName, String employeeSeconName) {
        return employeeFirstName + employeeSeconName;
    }

    public List<Employee> findAll() {
        return List.copyOf(employees.values());
    }
}
