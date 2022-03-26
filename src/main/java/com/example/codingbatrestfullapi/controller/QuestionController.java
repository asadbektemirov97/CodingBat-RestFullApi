package com.example.codingbatrestfullapi.controller;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.dto.QuestionDTO;
import com.example.codingbatrestfullapi.entity.Question;
import com.example.codingbatrestfullapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {

    final QuestionService questionService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Question> all = questionService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = questionService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody QuestionDTO dto) {
        ApiResponse apiResponse = questionService.save(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody QuestionDTO dto) {
        ApiResponse apiResponse = questionService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = questionService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
