package ru.skypro.dz31.service;

import ru.skypro.dz31.model.Student;
import java.util.*;

public interface StudentService {

    Student update(long index, Student student);

    Student get(long index);

    Student delete(long index);

    Student create(Student student);

    List<Student> sortMap(int age);
}
