package ru.skypro.dz3_3.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz3_3.model.Faculty;
import ru.skypro.dz3_3.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;


@Service
public class FacultyServiceBD {
    private final FacultyRepository facultyRepository;

    public FacultyServiceBD(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> findAll(long id) {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> findById(long id) {
        return facultyRepository.findById(id);
    }

//    public void updateFaculty(Faculty faculty) {
//        facultyRepository.update(faculty);
//    }

    public void remove(Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}
