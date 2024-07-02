package ru.skypro.kursovaya2.service.impl;

import ru.skypro.kursovaya2.exception.IncorrectAmountException;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.ExaminerService;
import ru.skypro.kursovaya2.service.QuestionService;

import java.util.*;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (service.getAll().size() < amount || amount <= 0) {
            throw new IncorrectAmountException();
        }
        Set<Question> listQuestion = new HashSet<>(amount);
        while (listQuestion.size() < amount) {
            listQuestion.add(service.getRandomQuestion());
        }
        return listQuestion;
    }
}

