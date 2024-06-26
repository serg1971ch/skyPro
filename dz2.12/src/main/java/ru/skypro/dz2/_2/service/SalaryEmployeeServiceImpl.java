package ru.skypro.dz2._2.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz2._2.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    public int sumSalaryBranch(int branch) {
        return service.findAll().stream()
                .filter(e ->e.getBranch() == branch)
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
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
