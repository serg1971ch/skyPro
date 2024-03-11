package model;

import java.util.Objects;

public class Employee {
    private static int id = 1;
    private final int idEmployee;

    private final String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.idEmployee = id++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int idEmployee, String name) {
        this.idEmployee = idEmployee++;
        this.name = name;
    }

    public int getId() {
        return idEmployee;
    }


    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Идентификатор - " + getId() +" ФИО - " + name + '\'' +
                ", отдел -'" + department + '\'' +
                ", зарплата -" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }
}
