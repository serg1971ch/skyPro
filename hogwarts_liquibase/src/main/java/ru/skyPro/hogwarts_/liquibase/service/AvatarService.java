package ru.skyPro.hogwarts_.liquibase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.skyPro.hogwarts_.liquibase.exceptions.AvatarProcessingException;
import ru.skyPro.hogwarts_.liquibase.exceptions.StudentNotFoundException;
import ru.skyPro.hogwarts_.liquibase.model.Avatar;
import ru.skyPro.hogwarts_.liquibase.model.Student;
import ru.skyPro.hogwarts_.liquibase.repository.AvatarRepository;
import ru.skyPro.hogwarts_.liquibase.repository.StudentRepository;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@PropertySource("classpath:application.yaml")
public class AvatarService {

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;
    private final Path path;

    public AvatarService(StudentRepository studentRepository,
                         AvatarRepository avatarRepository,
                         @Value("avatars-dir-name") String applicationDirName) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
        path = Paths.get(applicationDirName);
    }

    @Transactional
    public void uploadAvatar(MultipartFile multipartFile, long studentId) {
        try {
            byte[] data = multipartFile.getBytes();
            String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
            Path avatarPath = path.resolve(UUID.randomUUID() + "." + extension);
            Files.write(path, data);
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentNotFoundException(studentId));
            Avatar avatar = avatarRepository.findByStudent_Id(studentId)
                    .orElseGet(Avatar::new);
            avatar.setStudent(student);
            avatar.setBytes(data);
            avatar.setSize(data.length);
            avatar.setMediaType(multipartFile.getContentType());
            avatar.setPathFile(avatarPath.toString());
            avatarRepository.save(avatar);
        } catch (IOException e) {
            throw new AvatarProcessingException();
        }
    }

    public Pair<byte[], String> getAvatarFromDB(long studentId) {
        Avatar avatar = avatarRepository.findByStudent_Id(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        return Pair.of(avatar.getBytes(), avatar.getMediaType());
    }

    public Pair<byte[], String> getAvatarFromFS(long studentId) {
        try {
            Avatar avatar = avatarRepository.findByStudent_Id(studentId)
                    .orElseThrow(() -> new StudentNotFoundException(studentId));
            return Pair.of(Files.readAllBytes(Paths.get(avatar.getPathFile())), avatar.getMediaType());
        } catch (IOException e) {
            throw new AvatarProcessingException();
        }
    }

    public Page<Avatar> getAllAvatars(Pageable pageable) {
        return avatarRepository.findAll(pageable);
    }
}
