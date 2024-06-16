package com.question.controller;


import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question)
    {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll()
    {
        return questionService.get();
    }

    @GetMapping("/{QuestionId}")
    public Question getone(@PathVariable Long QuestionId)
    {
        return questionService.getOne(QuestionId);
    }

    // get all question of specific quiz

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId)
    {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
