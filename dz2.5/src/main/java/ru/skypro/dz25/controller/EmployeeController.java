package ru.skypro.dz25.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.dz25.model.Employee;
import ru.skypro.dz25.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/add/{first}/{second}")
    public void add(@PathVariable String first, @PathVariable String second) {
        service.add(first, second);
    }

    @RequestMapping(value = "/find/{first}/{second}")
    public String findEmployee(@PathVariable String first, @PathVariable String second) {
        return service.findEmployee(first, second);
    }

    @RequestMapping(value = "/remove/{first}/{second}")
    public void remove(@PathVariable String first, @PathVariable String second) {
        service.remove(first, second);
    }

    @RequestMapping(value = "/add/all")
    public List<Employee> findAll() {
        return service.findAll();
    }
}
