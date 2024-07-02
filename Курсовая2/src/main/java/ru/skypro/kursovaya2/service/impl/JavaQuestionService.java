package ru.skypro.kursovaya2.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.kursovaya2.exception.QuestionAlreadyAddedException;
import ru.skypro.kursovaya2.exception.QuestionAreEmptyException;
import ru.skypro.kursovaya2.exception.QuestionNotFoundException;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.QuestionService;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class JavaQuestionService implements QuestionService {

    public Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if(!questions.add(question)) {
            throw new QuestionAlreadyAddedException("Question уже существует");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!questions.remove(question)) {
            throw new QuestionNotFoundException("Question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.isEmpty()) {
            throw new QuestionAreEmptyException("Список вопросов пустой");
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(questions.size());
        return questions.stream()
                .skip(randomIndex)
                .findFirst()
                .orElseThrow();
    }
}
