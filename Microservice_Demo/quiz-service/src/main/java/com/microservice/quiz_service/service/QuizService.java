package com.microservice.quiz_service.service;


import com.microservice.quiz_service.dao.QuizDao;
import com.microservice.quiz_service.entity.QuestionWrapper;

import com.microservice.quiz_service.entity.Quiz;
import com.microservice.quiz_service.entity.Response;
import com.microservice.quiz_service.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
  QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//
     List<Integer> questions=quizInterface.getQuestionsForOuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionByID(int id) {
        Quiz quiz=quizDao.findById(id).get();
        List<Integer> questionIds=quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);


//
        return questions;
    }

    public ResponseEntity<Integer> calcualateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score=quizInterface.getScore(responses);
        return score;


    }
}
