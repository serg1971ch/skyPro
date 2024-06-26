package ru.skypro.dz2._2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.dz2._2.model.Employee;
import ru.skypro.dz2._2.service.EmployeeService;
import ru.skypro.dz2._2.service.SalaryEmployeeServiceImpl;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeesAllDepartmentsTest {
    @Mock
    EmployeeService service;

    @InjectMocks
    SalaryEmployeeServiceImpl employeeService;

    private final List<Employee> employeesBranch1 = List.of(
            new Employee("John", "Doe", 1, 5000),
            new Employee("Peter", "Long", 1, 8000),
            new Employee("Jane", "Sem", 1, 3000),
            new Employee("Jimmy", "Vice", 1, 5400),
            new Employee("Andre", "Rage", 1, 6900),
            new Employee("John", "Smith", 1, 7000),
            new Employee("Veronika", "Gold", 1, 12000)
    );

    private final List<Employee> employeesBranch2 = List.of(
            new Employee("Gans", "Leopard", 2, 2500),
            new Employee("Bill", "Leo", 2, 2000),
            new Employee("Samuel", "Kit", 2, 5000),
            new Employee("Rams", "Village", 2, 1500),
            new Employee("Emily", "Johnson", 2, 5000)
    );

    private final List<Employee> employeesBranch3 = List.of(
            new Employee("Jacob", "Williams", 3, 91000),
            new Employee("Ava", "Brown", 3, 13000),
            new Employee("Tomas", "Murphy", 3, 16500),
            new Employee("George", "Davis", 3, 17700),
            new Employee("Isabella", "Miller", 3, 187000),
            new Employee("Sophie", "Morton", 3, 22000),
            new Employee("Oskar", "Wilson", 3, 32000)
    );

    private final Map<Integer, List<Employee>> employees = Map.of(
            1, employeesBranch1,
            2, employeesBranch2,
            3, employeesBranch3
    );


    @Test
    public void findEmployeesFromDepartmentTest() {
        Mockito.when(employeeService.allEmployeeAllBranches()).thenReturn(employees);
    }
}
