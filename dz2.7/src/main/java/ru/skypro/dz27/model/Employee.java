package ru.skypro.dz27.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;

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

    @Override
    public String toString() {
        return "Имя - " + getFirstName() +" Фамилия - " + getSecondName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }
}
