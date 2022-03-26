package com.example.codingbatrestfullapi.service;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.dto.QuestionDTO;
import com.example.codingbatrestfullapi.entity.Category;
import com.example.codingbatrestfullapi.entity.Question;
import com.example.codingbatrestfullapi.repository.CategoryRepository;
import com.example.codingbatrestfullapi.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    final CategoryRepository categoryRepository;
    final QuestionRepository questionRepository;

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Question> byId = questionRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Question not found", false);
        return new ApiResponse("Mana", true, byId.get());
    }

    public ApiResponse save(QuestionDTO dto) {
        Question question = new Question();
        question.setText(dto.getText());
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik", false);
        question.setCategory(byId.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, QuestionDTO dto) {
        Optional<Question> byId1 = questionRepository.findById(id);
        if (!byId1.isPresent()) return new ApiResponse("Xatolik", false);
        Question question = byId1.get();
        question.setText(dto.getText());
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isEmpty()) return new ApiResponse("Xatolik", false);
        question.setCategory(byId.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        questionRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}
