package ru.skypro.dz2._2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ru.skypro.dz2._2.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.dz2._2.exceptions.EmployeeNotFoundException;
import ru.skypro.dz2._2.exceptions.EmployeeStorageIsFullException;
import ru.skypro.dz2._2.model.Employee;
import ru.skypro.dz2._2.service.EmployeeService;
import ru.skypro.dz2._2.service.EmployeeServiceImpl;
import ru.skypro.dz2._2.service.SalaryEmployeeService;
import ru.skypro.dz2._2.service.SalaryEmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Autowired
    EmployeeServiceImpl serviceImpl;

    @Test
    public void addEmployeeSuccess() {
        Employee employee = serviceImpl.add("John", "Doe", 1, 5000);
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getSecondName());
        assertEquals(1, employee.getBranch());
        assertEquals(5000, employee.getSalary());
    }

    @Test
    public void addEmployeeAlreadyExists() {
        serviceImpl.add("Jane", "Doe", 1, 5000);
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                serviceImpl.add("Jane", "Doe", 1, 5000));
    }

//    @Test
//    public void addEmployeeExceedsLimit() {
//
//        employeeService.add("John", "Doe", 1, 5000);
//        employeeService.add("Kate", "Doe", 1, 5000);
//
//        assertThrows(EmployeeStorageIsFullException.class, () ->
//                employeeService.add("Jane", "Doe", 1, 5000));
//    }

    @Test
    public void removeEmployeeSuccess() {
        serviceImpl.add("John", "Doe", 1, 5000);
        Employee employee = serviceImpl.remove("John", "Doe");
        assertNotNull(employee);
    }

    @Test
    public void removeEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () ->
                serviceImpl.remove("John", "Doe"));
    }

    @Test
    public void findEmployeeSuccess() {
        serviceImpl.add("John", "Doe", 1, 5000);
        Employee employee = serviceImpl.findEmployee("John", "Doe");
        assertNotNull(employee);
    }

    @Test
    public void findEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () ->
                serviceImpl.findEmployee("John", "Doe"));
    }

    @Test
    public void findAllEmployees() {
        serviceImpl.add("John", "Doe", 1, 5000);
        serviceImpl.add("Jane", "Doe", 2, 6000);
        assertEquals(2, serviceImpl.findAll().size());
    }
}
