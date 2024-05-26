package ru.skypro.dz29.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz29.model.Employee;
import ru.skypro.dz29.service.SalaryEmployeeService;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class SalaryEmployeeServiceImpl implements SalaryEmployeeService {

    private final EmployeeService service;

    public SalaryEmployeeServiceImpl(EmployeeService service) {
        this.service = service;
    }

    @Override
    public Employee maxSalary(int branch) {
        return service.findAll().stream()
                .filter(e -> e.getBranch() == branch)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee minSalary(int branch) {
        return service.findAll().stream()
                .filter(e -> e.getBranch() == branch)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeeBranch(int branch) {
        return service.findAll().stream()
                .filter(e -> e.getBranch() == branch)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeAllBranches() {
        return service.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getBranch));
    }
}
