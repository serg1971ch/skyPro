package ru.skypro.dz3_3.service.students;

import ru.skypro.dz3_3.model.Student;

import java.util.List;

public interface StudentService {

    Student update(long index, Student student);

    Student get(long index);

    Student delete(long index);

    Student create(Student student);

    List<Student> sortMap(int age);
}
