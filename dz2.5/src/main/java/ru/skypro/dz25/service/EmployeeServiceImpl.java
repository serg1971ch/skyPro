package ru.skypro.dz25.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz25.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.dz25.exceptions.EmployeeNotFoundException;
import ru.skypro.dz25.exceptions.EmployeeStorageIsFullException;
import ru.skypro.dz25.model.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public void add(String employeeFirstName, String employeeSeconName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        for (Employee emp : employeeList) {
            if (Objects.equals(emp.getFirstName(), employeeFirstName) && Objects.equals(emp.getSecondName(), employeeSeconName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
            } else if (employeeList.size() > 10) {
                throw new EmployeeStorageIsFullException("Вы превысили лимит сотрудников в компании");
            }
            employeeList.add(new Employee(employeeFirstName, employeeSeconName));
        }
    }

    @Override
    public void remove(String employeeFirstName, String employeeSeconName) throws EmployeeNotFoundException {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee nexEmployee = employeeIterator.next();
            if (nexEmployee.getFirstName() != employeeFirstName && nexEmployee.getSecondName() != employeeSeconName) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
            employeeIterator.remove();
        }
    }

    @Override
    public String findEmployee(String employeeFirstName, String employeeSeconName) {
        Employee employee = null;
        for (Employee currentEmp : employeeList) {
            if (currentEmp.getFirstName() != employeeFirstName && currentEmp.getSecondName() != employeeSeconName) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }

        }
        return employee.getSecondName();
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
