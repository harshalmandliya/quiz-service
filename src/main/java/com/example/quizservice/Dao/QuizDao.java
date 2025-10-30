package com.example.quizservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizservice.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
