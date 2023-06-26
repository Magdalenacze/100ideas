package com.example.ideas.question.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.ideas.question.service.QuestionService;
import com.example.ideas.question.domain.model.Question;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("api/v1/questions")
public class QuestionApiController {
    private final QuestionService questionsService;
    public QuestionApiController(QuestionService questionsService) {
        this.questionsService = questionsService;
    }
    @GetMapping
    List<Question> getQuestions() {
        return questionsService.getQuestions();
    }
    @GetMapping("{id}")
    Question getQuestion(@PathVariable UUID id) {
        return questionsService.getQuestion(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Question createQuestion(@RequestBody Question question) {
        return questionsService.createQuestion(question);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Question updateQuestion(@PathVariable UUID id, @RequestBody Question question){
        return questionsService.updateQuestion(id, question);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteQuestion(@PathVariable UUID id) {
        questionsService.deleteQuestion(id);
    }
}
