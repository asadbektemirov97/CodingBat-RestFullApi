package com.example.codingbatrestfullapi.repository;

import com.example.codingbatrestfullapi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
