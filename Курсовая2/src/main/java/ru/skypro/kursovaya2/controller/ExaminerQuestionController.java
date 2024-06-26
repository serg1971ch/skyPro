package ru.skypro.kursovaya2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExaminerQuestionController {

    private final ExaminerService examinerService;

    public ExaminerQuestionController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getAmountQuestions(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }
}
