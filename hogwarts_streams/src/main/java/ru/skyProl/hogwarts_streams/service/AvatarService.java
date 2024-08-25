package ru.skyProl.hogwarts_streams.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.skyProl.hogwarts_streams.exceptions.AvatarProcessingException;
import ru.skyProl.hogwarts_streams.exceptions.StudentNotFoundException;
import ru.skyProl.hogwarts_streams.model.Avatar;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.repository.AvatarRepository;
import ru.skyProl.hogwarts_streams.repository.StudentRepository;

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
    private final Logger logger = LoggerFactory.getLogger(AvatarService.class);

    public AvatarService(StudentRepository studentRepository,
                         AvatarRepository avatarRepository,
                         @Value("avatars-dir-name") String applicationDirName) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
        path = Paths.get(applicationDirName);
    }

    @Transactional
    public void uploadAvatar(MultipartFile multipartFile, long studentId) {
        logger.info("Was invoked method upload avatar");
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
        logger.info("Was invoked method find avatar from database with student id = {}", studentId);
        Avatar avatar = avatarRepository.findByStudent_Id(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        return Pair.of(avatar.getBytes(), avatar.getMediaType());
    }

    public Pair<byte[], String> getAvatarFromFS(long studentId) {
        logger.info("Was invoked method find avatar from file with student id = {}", studentId);
        try {
            Avatar avatar = avatarRepository.findByStudent_Id(studentId)
                    .orElseThrow(() -> new StudentNotFoundException(studentId));
            return Pair.of(Files.readAllBytes(Paths.get(avatar.getPathFile())), avatar.getMediaType());
        } catch (IOException e) {
            throw new AvatarProcessingException();
        }
    }

    public Page<Avatar> getAllAvatars(Pageable pageable) {
        logger.info("Was invoked method for finding all avatars");
        return avatarRepository.findAll(pageable);
    }
}
