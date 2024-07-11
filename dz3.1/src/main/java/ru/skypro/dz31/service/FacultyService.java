package ru.skypro.dz31.service;

import ru.skypro.dz31.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty create(Faculty faculty);

    Faculty update(long id, Faculty faculty);

    Faculty get(long id);

    Faculty delete(long id);

    List<Faculty> sortMap(String color);

}
