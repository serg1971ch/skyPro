package ru.skypro.kursovaya2.service;

import ru.skypro.kursovaya2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
