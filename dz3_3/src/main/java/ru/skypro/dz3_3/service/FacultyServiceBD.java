package ru.skypro.dz3_3.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz3_3.model.Faculty;
import ru.skypro.dz3_3.repository.FacultyRepository;


@Service
public class FacultyServiceBD {
    private final FacultyRepository facultyRepository;

    public FacultyServiceBD(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {

        return faculty;
    }
}
