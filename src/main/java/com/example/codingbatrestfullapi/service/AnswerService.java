package com.example.codingbatrestfullapi.service;

import com.example.codingbatrestfullapi.dto.AnswerDTO;
import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.entity.Answer;
import com.example.codingbatrestfullapi.entity.Question;
import com.example.codingbatrestfullapi.entity.User;
import com.example.codingbatrestfullapi.repository.AnswerRepository;
import com.example.codingbatrestfullapi.repository.QuestionRepository;
import com.example.codingbatrestfullapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    final AnswerRepository answerRepository;
    final QuestionRepository questionRepository;
    final UserRepository userRepository;

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Answer> byId = answerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Answer not found", false);
        return new ApiResponse("Mana", true, byId.get());
    }

    public ApiResponse save(AnswerDTO dto) {
        Answer answer = new Answer();
        answer.setContent(dto.getContent());
        Optional<User> byId = userRepository.findById(dto.getUserId());
        if (byId.isEmpty()) return new ApiResponse("User topilmadi", false);
        answer.setUser(byId.get());
        Optional<Question> byId1 = questionRepository.findById(dto.getQuestionId());
        if (byId1.isEmpty()) return new ApiResponse("Savol topilmadi", false);
        answer.setQuestion(byId1.get());
        Answer save = answerRepository.save(answer);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, AnswerDTO dto) {

        Optional<Answer> byId2 = answerRepository.findById(id);
        if (!byId2.isPresent()) return new ApiResponse("Xatolik", false);
        Answer answer = byId2.get();
        answer.setContent(dto.getContent());
        Optional<User> byId = userRepository.findById(dto.getUserId());
        if (byId.isEmpty()) return new ApiResponse("User topilmadi", false);
        answer.setUser(byId.get());
        Optional<Question> byId1 = questionRepository.findById(dto.getQuestionId());
        if (byId1.isEmpty()) return new ApiResponse("Savol topilmadi", false);
        answer.setQuestion(byId1.get());
        Answer save = answerRepository.save(answer);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        answerRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}
