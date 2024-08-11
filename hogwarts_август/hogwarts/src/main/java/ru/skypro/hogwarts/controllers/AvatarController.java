package ru.skypro.hogwarts.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.hogwarts.model.Avatar;
import ru.skypro.hogwarts.service.AvatarService;


@RestController
@RequestMapping("/avatars")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadAvatar(@RequestParam("avatar") MultipartFile multipartFile,
                             @RequestParam long studentId) {
        avatarService.uploadAvatar(multipartFile, studentId);
    }

    @GetMapping
    public ResponseEntity<Page<Avatar>> getAllAvatars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Avatar> avatarPage = avatarService.getAllAvatars(pageable);
        return ResponseEntity.ok(avatarPage);
    }
}
