package com.microservice.question_service.controller;


import com.microservice.question_service.entity.Question;
import com.microservice.question_service.entity.QuestionWrapper;
import com.microservice.question_service.entity.Response;
import com.microservice.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
       return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable
                                                        String category){
        return questionService.getAllQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForOuiz(@RequestParam String category,@RequestParam Integer numQ)
    {
        return questionService.getQuestionsForQuiz(category,numQ);
    }
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestionsFromId(@RequestBody List<Integer> questionIds)
    {
      return questionService.getQuestionsFromId(questionIds);
    }
@GetMapping("getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
{
    return questionService.getScore(responses);
}

}
