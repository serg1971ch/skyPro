package ru.skypro.dz3_3.service.students;

import org.springframework.stereotype.Service;
import ru.skypro.dz3_3.exceptions.StudentAlreadyAddedException;
import ru.skypro.dz3_3.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private static Long identifier = 1L;
    private final Map<Long, Student> students = new HashMap<>();

    @Override
    public Student create(Student student) {
        if (students.containsKey(identifier)) {
            throw new StudentAlreadyAddedException("Студент уже существует");
        }
        student.setId(identifier++);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student update(long id, Student student) {
        if (!students.containsKey(id)) {
            throw new StudentAlreadyAddedException("Студент не найден");
        }
        student.setId(id);
        students.replace(id, student);
        return students.get(id);
    }

    @Override
    public Student get(long id) {
        if (!students.containsKey(id)) {
            throw new StudentAlreadyAddedException("Студент не найден");
        }
        return students.get(id);
    }

    @Override
    public Student delete(long id) {
        if (!students.containsKey(id)) {
            throw new StudentAlreadyAddedException("Студент не найден");
        }
        return students.remove(id);
    }

    @Override
    public List <Student> sortMap(int age) {
            return students.values().stream()
                    .filter(student -> student.getAge() == age)
                    .toList();
    }
}
