package com.example.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quizservice.QuestionWrapper;
import com.example.quizservice.Response;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/questions/generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,
                                                      @RequestParam int numQuestions);

    @PostMapping("/questions/getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/questions/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
