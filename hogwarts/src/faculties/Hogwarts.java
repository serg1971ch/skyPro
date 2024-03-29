package faculties;

import studentsFaculties.Student;

public class Hogwarts {
    private Student[] students;

    public Hogwarts(Student[] students) {
        this.students = new Student[3];
    }
/*
Сделайте метод, который выводит на экран описание студента. В описание надо включать качества,
которые присущи всем студентам, плюс качества, которые присущи студенту,
потому что он учится на конкретном факультете.
 */

    public void getStudent(Student student) {
        System.out.println("Описание качеств " + student.toString());
        for (String value : student.getNameQualityStudent()) {
            System.out.println(value);
        }
    }
}

