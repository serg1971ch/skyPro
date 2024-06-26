package ru.skypro.dz2._2.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;
    private int branch;
    private int salary;

    public Employee(String firstName, String secondName, int branch, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.branch = branch;
        this.salary = salary;
    }

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName) && Objects.equals(branch, employee.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, branch, salary);
    }

    public int getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "Имя - " + getFirstName() + " Фамилия - " + getSecondName()
                + " Отдел - " + getBranch()
                + " Зарплата - " + getSalary();
    }
}
