package com.example.ideas.question.service;

import com.example.ideas.category.domain.repository.CategoryRepository;
import com.example.ideas.question.domain.model.Question;
import com.example.ideas.question.domain.repository.AnswerRepository;
import com.example.ideas.question.domain.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class QuestionServiceIT {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AnswerRepository answerRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void schouldGetAllQuestions() {

        // given
        questionRepository.deleteAll();

        questionRepository.saveAll(List.of(
                new Question("Question 1"),
                new Question("Question 2"),
                new Question("Question 3")
        ));

        // when
        List<Question> questions = questionService.getQuestions();

        // then
        assertThat(questions)
                .hasSize(3)
                .extracting(Question::getName)
                .containsExactlyInAnyOrder("Question 1", "Question 2", "Question 3");
    }
    @Test
    void schouldSingleGetQuestion() {

        // given
        Question question = new Question("Question 2");

        questionRepository.saveAll(List.of(
                new Question("Question 1"),
                question,
                new Question("Question 3")

        ));

        //when
        Question result = questionService.getQuestion(question.getId());

        //then
        assertThat(result.getId()).isEqualTo(question.getId());
    }
    @Test
    void schouldCreateQuestion() {

        // given
        Question question = new Question("Question");

        //when
        Question result = questionService.createQuestion(question);

        //then
        assertThat(result.getName()).isEqualTo(question.getName());
        assertThat(result.getName()).isEqualTo(questionRepository.getById(result.getId()).getName());
    }
    @Test
    void shouldUpdateQuestion() {

        // given
        Question question = new Question("Question");
        question = questionService.createQuestion(question);

        question.setName("updated");
    }
    @Test
    void schouldDeleteQuestion() {
    }
    @Test
    void schouldFindAllByCategoryId() {
    }
    @Test
    void schouldFindHot() {
    }
    @Test
    void schouldFindUnanswered() {
    }
    @Test
    void schouldFindByQuery() {
    }
}