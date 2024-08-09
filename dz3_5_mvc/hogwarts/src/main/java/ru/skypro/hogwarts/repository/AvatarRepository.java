package ru.skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.hogwarts.model.Avatar;


import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudent_Id(Long id);
}
