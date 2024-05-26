package ru.skypro.dz29.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.dz29.model.Employee;
import ru.skypro.dz29.service.SalaryEmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/departments/")
public class EmployeeDepartmentController {

    private final SalaryEmployeeService departmentService;

    public EmployeeDepartmentController(SalaryEmployeeService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary/{branchId}")
    public Employee findMaxSalaryEmployee(@PathVariable int branchId) {
        return departmentService.maxSalary(branchId);
    }

    @GetMapping("min-salary/{branchId}")
    public Employee findMinSalaryEmployee(@PathVariable int branchId) {
        return departmentService.minSalary(branchId);
    }

    @GetMapping(value = "all/{branchId}")
    public List<Employee> findMasSalaryEmployee(@PathVariable int branchId) {
        return departmentService.allEmployeeBranch(branchId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> allEmployeeAllBranches() {
        return departmentService.allEmployeeAllBranches();
    }
}