package ru.skypro.dz29.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skypro.dz29.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.dz29.exceptions.EmployeeNotFoundException;
import ru.skypro.dz29.exceptions.EmployeeStorageIsFullException;
import ru.skypro.dz29.exceptions.EmployeeWrongNameExctption;
import ru.skypro.dz29.model.Employee;
import ru.skypro.dz29.service.EmployeeService;


import java.util.List;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int maxEmployee = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public String validationNamesEmployee(String nameEmployee) {
        nameEmployee = nameEmployee.trim();
        if (!StringUtils.isAlpha(nameEmployee)) {
            throw new EmployeeWrongNameExctption("должны быть только буквы");
        }
        return StringUtils.capitalize(nameEmployee.toLowerCase());
    }

    @Override
    public Employee add(String employeeFirstName, String employeeSecondName, int branchId, int salary) {
        employeeFirstName = validationNamesEmployee(employeeFirstName);
        employeeSecondName = validationNamesEmployee(employeeSecondName);
        String key = buildKey(employeeFirstName, employeeSecondName);
        if (employees.containsKey(key)) {
            System.out.println(employees);
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        } else if (employees.size() > maxEmployee) {
            throw new EmployeeStorageIsFullException("Вы превысили лимит сотрудников в компании");
        }
        Employee employee = new Employee(employeeFirstName, employeeSecondName, branchId, salary);
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
