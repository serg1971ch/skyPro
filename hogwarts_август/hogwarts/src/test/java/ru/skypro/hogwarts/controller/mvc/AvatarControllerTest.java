package ru.skypro.hogwarts.controller.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.skypro.hogwarts.controllers.AvatarController;
import ru.skypro.hogwarts.model.Avatar;
import ru.skypro.hogwarts.service.AvatarService;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(AvatarController.class)
public class AvatarControllerTest {

    @InjectMocks
    private AvatarController avatarController;
    @MockBean
    private AvatarService avatarService;

    @BeforeEach
    void setUp() {
        avatarService = Mockito.mock(AvatarService.class);
        avatarController = new AvatarController(avatarService);
    }

    @Test
    void getAllAvatars_ReturnsPageOfAvatars() {
        // Подготовка данных для теста
        Avatar avatar1 = new Avatar();
        avatar1.setId(1L);
        avatar1.setPathFile("path/to/avatar1.png");
        avatar1.setSize(12345);
        avatar1.setMediaType("image/png");

        Avatar avatar2 = new Avatar();
        avatar2.setId(2L);
        avatar2.setPathFile("path/to/avatar2.png");
        avatar2.setSize(67890);
        avatar2.setMediaType("image/png");

        Pageable pageable = PageRequest.of(0, 10);
        Page<Avatar> avatarPage = new PageImpl<>(Arrays.asList(avatar1, avatar2), pageable, 2);

        // Настройка Mock поведения
        when(avatarService.getAllAvatars(pageable)).thenReturn(avatarPage);

        // Выполнение запроса
        ResponseEntity<Page<Avatar>> responseEntity = avatarController.getAllAvatars(0, 10);

        // Проверка статуса ответа
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        // Проверка содержимого страницы
        Page<Avatar> body = responseEntity.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getTotalElements()).isEqualTo(2);
        assertThat(body.getContent()).hasSize(2);
        assertThat(body.getContent()).containsExactlyInAnyOrder(avatar1, avatar2);
    }

    @Test
    void getAllAvatars_EmptyPage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Avatar> avatarPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        // Настройка Mock поведения
        when(avatarService.getAllAvatars(pageable)).thenReturn(avatarPage);

        // Выполнение запроса
        ResponseEntity<Page<Avatar>> responseEntity = avatarController.getAllAvatars(0, 10);

        // Проверка статуса ответа
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        // Проверка содержимого страницы
        Page<Avatar> body = responseEntity.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getTotalElements()).isEqualTo(0);
        assertThat(body.getContent()).isEmpty();
    }
}
