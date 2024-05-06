package ru.skypro.dz27.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.dz27.model.Employee;
import ru.skypro.dz27.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/add/{first}/{second}")
    public Employee add(@PathVariable String first, @PathVariable String second) {
        return service.add(first, second);
    }

    @RequestMapping(value = "/find/{first}/{second}")
    public Employee findEmployee(@PathVariable String first, @PathVariable String second) {
        return service.findEmployee(first, second);
    }

    @RequestMapping(value = "/remove/{first}/{second}")
    public Employee remove(@PathVariable String first, @PathVariable String second) {
        return service.remove(first, second);
    }

    @RequestMapping(value = "/find/all")
    public List<Employee> findAll() {
        return service.findAll();
    }
}
