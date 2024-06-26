package ru.skypro.dz2._2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.dz2._2.model.Employee;
import ru.skypro.dz2._2.service.SalaryEmployeeService;

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

    @GetMapping("/{id}/salary/sum")
    public int  sumSalaryEmployeeOfBranch(@PathVariable int id) {
        return departmentService.sumSalaryBranch(id);
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