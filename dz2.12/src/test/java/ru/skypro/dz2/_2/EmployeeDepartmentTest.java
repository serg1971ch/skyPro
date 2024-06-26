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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeDepartmentTest {

    @Mock
    EmployeeService service;

    @InjectMocks
    SalaryEmployeeServiceImpl employeeService;

    private final List<Employee> employees = List.of(
            new Employee("John", "Doe", 1, 5000),
            new Employee("Peter", "Long", 1, 8000),
            new Employee("Jane", "Sem", 1, 3000),
            new Employee("Jimmy", "Vice", 1, 5400),
            new Employee("Andre", "Rage", 1, 6900),
            new Employee("John", "Smith", 1, 7000),
            new Employee("Veronika", "Gold", 1, 12000),
            new Employee("Gans", "Leopard", 2, 2500),
            new Employee("Bill", "Leo", 2, 2000),
            new Employee("Samuel", "Kit", 2, 5000),
            new Employee("Rams", "Village", 2, 1500),
            new Employee("Emily", "Johnson", 2, 5000),
            new Employee("Jacob", "Williams", 3, 91000),
            new Employee("Ava", "Brown", 3, 13000),
            new Employee("Tomas", "Murphy", 3, 16500),
            new Employee("George", "Davis", 3, 17700),
            new Employee("Isabella", "Miller", 3, 187000),
            new Employee("Sophie", "Morton", 3, 22000),
            new Employee("Oskar", "Wilson", 3, 32000)
    );

    @BeforeEach
    public void beforeEach() {
        Mockito.when(service.findAll()).thenReturn(employees);
    }

    @Test
    public void findEmployeesFromDepartmentTest() {
        assertThat(employeeService.allEmployeeBranch(1)).containsExactlyInAnyOrder(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Peter", "Long", 1, 8000),
                new Employee("Jane", "Sem", 1, 3000),
                new Employee("Jimmy", "Vice", 1, 5400),
                new Employee("Andre", "Rage", 1, 6900),
                new Employee("John", "Smith", 1, 7000),
                new Employee("Veronika", "Gold", 1, 12000)
        );
    }

    @Test
    public void minSalaryBranch() {
        assertThat(employeeService.minSalary(1).getSalary()).isEqualTo(3000);
    }

    @Test
    public void maxSalaryBranch() {
        assertThat(employeeService.maxSalary(1).getSalary()).isEqualTo(12000);
    }

    @Test
    public void minSalarySecondBranch() {
        assertThat(employeeService.minSalary(2).getSalary()).isEqualTo(1500);
    }

    @Test
    public void maxSalarySecondBranch() {
        assertThat(employeeService.maxSalary(2).getSalary()).isEqualTo(5000);
    }

    @Test
    public void sumSalaryDepartmentBranch() {
        assertThat(employeeService.sumSalaryBranch(3)).isEqualTo(379200);
    }

    @Test
    public void findEmployeesAllDepartmentsBranchTest() {
        assertThat(employeeService.allEmployeeBranch(1)).containsExactlyInAnyOrder(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Peter", "Long", 1, 8000),
                new Employee("Jane", "Sem", 1, 3000),
                new Employee("Jimmy", "Vice", 1, 5400),
                new Employee("Andre", "Rage", 1, 6900),
                new Employee("John", "Smith", 1, 7000),
                new Employee("Veronika", "Gold", 1, 12000)
        );
    }
}
