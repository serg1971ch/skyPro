package ru.skypro.dz2._2.service;

import ru.skypro.dz2._2.model.Employee;

import java.util.List;
import java.util.Map;

public interface SalaryEmployeeService {
    Employee maxSalary(int branch);
    Employee minSalary(int branch);
    int sumSalaryBranch(int branch);
    List<Employee> allEmployeeBranch(int branch);
    Map<Integer, List<Employee>> allEmployeeAllBranches();
}
