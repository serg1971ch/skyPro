package ru.skypro.dz31.service;

import ru.skypro.dz31.model.Faculty;
import ru.skypro.dz31.exceptions.FacultyAlreadyAddedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyServiceImpl implements FacultyService{

    private static Long identifier = 1L;
    private final Map<Long, Faculty> faculties = new HashMap<>();
    @Override
    public Faculty create(Faculty faculty) {
        if (faculties.containsKey(identifier)) {
            throw new FacultyAlreadyAddedException("Студент уже существует");
        }
        faculty.setId(identifier++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty update(long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
            throw new FacultyAlreadyAddedException("Факультет не найден");
        }
        faculty.setId(id);
        faculties.replace(id, faculty);
        return faculties.get(id);
    }

    @Override
    public Faculty get(long id) {
        if (!faculties.containsKey(id)) {
            throw new FacultyAlreadyAddedException("Факультет не найден");
        }
        return faculties.get(id);
    }

    @Override
    public Faculty delete(long id) {
        if (!faculties.containsKey(id)) {
            throw new FacultyAlreadyAddedException("Факультет не найден");
        }
        return faculties.remove(id);
    }

    @Override
    public List<Faculty> sortMap(String color) {
        return faculties.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .toList();
    }
}
