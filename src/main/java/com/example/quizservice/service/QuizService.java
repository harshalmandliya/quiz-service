package com.example.quizservice.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizservice.QuestionWrapper;
import com.example.quizservice.Quiz;
import com.example.quizservice.Response;
import com.example.quizservice.Dao.QuizDao;
import com.example.quizservice.feign.QuizInterface;

@Service
public class QuizService {
@Autowired
	QuizDao quizDao;
@Autowired
QuizInterface quizInterface;
	/*
	 * @Autowired QuestionDao questionDao;
	 */
	public  ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	List<Integer> questions=quizInterface.getQuestionsForQuiz(category, numQ).getBody();
	Quiz quiz=new Quiz();
	quiz.setTitle(title);
	quiz.setQuestionIds(questions);
	quizDao.save(quiz);
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
           Quiz quiz=quizDao.findById(id).get();
           List<Integer> questionIds=quiz.getQuestionIds();
           
           ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);
 			return questions;
	}
	public ResponseEntity<Integer> submit(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
		return score;
	}
}
