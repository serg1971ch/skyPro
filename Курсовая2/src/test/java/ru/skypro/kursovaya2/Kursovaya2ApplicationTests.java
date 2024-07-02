package ru.skypro.kursovaya2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skypro.kursovaya2.exception.QuestionAlreadyAddedException;
import ru.skypro.kursovaya2.exception.QuestionAreEmptyException;
import ru.skypro.kursovaya2.exception.QuestionNotFoundException;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.QuestionService;
import ru.skypro.kursovaya2.service.impl.JavaQuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class Kursovaya2ApplicationTests {

    private final QuestionService service = new JavaQuestionService();
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
        questions.forEach(service::add);
    }

    @AfterEach
    public void afterEach() {
        Collection<Question> qtn = new ArrayList<>(service.getAll());
        qtn.forEach(service::remove);
    }

    @Test
    public void addQuestionsTest() {
        int countQuestions = service.getAll().size();
        Question expected = new Question("10 + 1 = ", "11");

        assertThat(service.getAll()).doesNotContain(expected);

        Question actual = service.add("10 + 1 = ", "11");

        assertThat(actual).isEqualTo(expected);
        assertThat(service.getAll()).hasSize(countQuestions + 1);
        assertThat(service.getAll()).contains(expected);
    }

    @Test
    public void addQuestionsNegativeTest() {
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> service.add(new Question("1 + 1 = ", "2")));
    }

    @Test
    public void addQuestionNegativeTest() {
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> service.add("1 + 1 = ", "2"));
    }

    @Test
    public void removeQuestionTest() {
        int countQuestions = service.getAll().size();
        Question expected = new Question("1 + 1 = ", "2");

        assertThat(service.getAll()).contains(expected);

        Question actual = service.remove(new Question("1 + 1 = ", "2"));

        assertThat(actual).isEqualTo(expected);
        assertThat(service.getAll()).hasSize(countQuestions - 1);
        assertThat(service.getAll()).doesNotContain(expected);
    }

    @Test
    public void removeQuestionNegativeTest() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> service.remove(new Question("10 + 1 = ", "11")));
    }

    @Test
    public void getAllQuestionsTest() {
        assertThat(service.getAll()).containsExactlyInAnyOrderElementsOf(questions);
    }

    @Test
    public void getRandomQuestionTest() {
        assertThat(service.getRandomQuestion()).isIn(service.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        afterEach();

        assertThatExceptionOfType(QuestionAreEmptyException.class)
                .isThrownBy(service::getRandomQuestion);
    }

}
