package ru.skypro.dz3_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.dz3_4.model.Avatar;
import ru.skypro.dz3_4.model.Student;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudent_Id(Long id);
}
