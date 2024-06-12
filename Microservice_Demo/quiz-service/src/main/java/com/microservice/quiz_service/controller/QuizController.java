package com.microservice.quiz_service.controller;

import com.microservice.quiz_service.entity.QuestionWrapper;
import com.microservice.quiz_service.entity.QuizDto;
import com.microservice.quiz_service.entity.Response;
import com.microservice.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable int id)
    {
        return quizService.getQuestionByID(id);
    }
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQ(),quizDto.getTitle());
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        return quizService.calcualateResult(id,responses);
    }

}
