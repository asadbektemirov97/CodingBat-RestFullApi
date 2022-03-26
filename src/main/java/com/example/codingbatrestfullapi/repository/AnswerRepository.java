package com.example.codingbatrestfullapi.repository;

import com.example.codingbatrestfullapi.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
