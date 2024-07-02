package ru.skypro.kursovaya2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.kursovaya2.exception.IncorrectAmountException;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.QuestionService;
import ru.skypro.kursovaya2.service.impl.ExaminerServiceImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService service;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private List<Question> questions = List.of(
            new Question("1 + 1 = ", "2"),
            new Question("2 + 2 = ", "4"),
            new Question("3 + 3 = ", "6"),
            new Question("4 + 4 = ", "8"),
            new Question("5 + 5 = ", "10"),
            new Question("6 + 6 = ", "12"),
            new Question("7 + 7 = ", "14"),
            new Question("8 + 8 = ", "16"),
            new Question("9 + 9 = ", "18"),
            new Question("10 + 10 = ", "20")
    );

    @BeforeEach
    public void beforeEach() {
        when(service.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsNegativeTest() {
        assertThatExceptionOfType(IncorrectAmountException.class)
                .isThrownBy(() -> examinerService.getQuestion(11));

        assertThatExceptionOfType(IncorrectAmountException.class)
                .isThrownBy(() -> examinerService.getQuestion(-1));
    }

    @Test
    public void getQuestionsTest() {
        when(service.getRandomQuestion()).thenReturn(
                new Question("2 + 2 = ", "4"),
                new Question("5 + 5 = ", "10"),
                new Question("6 + 6 = ", "12"),
                new Question("2 + 2 = ", "4"),
                new Question("8 + 8 = ", "16"),
                new Question("9 + 9 = ", "18"),
                new Question("2 + 2 = ", "4"),
                new Question("9 + 9 = ", "18"),
                new Question("10 + 10 = ", "20")
        );

        assertThat(examinerService.getQuestion(6)).containsExactlyInAnyOrder(
                new Question("2 + 2 = ", "4"),
                new Question("5 + 5 = ", "10"),
                new Question("6 + 6 = ", "12"),
                new Question("8 + 8 = ", "16"),
                new Question("9 + 9 = ", "18"),
                new Question("10 + 10 = ", "20")
        );
    }
}
