package ru.skypro.kursovaya2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.kursovaya2.model.Question;
import ru.skypro.kursovaya2.service.QuestionService;

import java.util.Collection;
import java.util.Collections;

@Controller
@RequestMapping
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                    @RequestParam String answer) {
        return questionService.add(new Question(question, answer));
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(new Question(question, answer));
    }

    @GetMapping("/findAll")
    public Collection<Question> findAllQuestions() {
        return questionService.getAll();
    }
}
