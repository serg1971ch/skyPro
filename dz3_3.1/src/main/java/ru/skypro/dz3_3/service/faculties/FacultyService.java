package ru.skypro.dz3_3.service.faculties;

import ru.skypro.dz3_3.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty create(Faculty faculty);

    void update(long id, Faculty faculty);

    Faculty get(long id);

    Faculty delete(long id);

    List<Faculty> sortMap(String color);

}
