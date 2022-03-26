package com.example.codingbatrestfullapi.controller;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.dto.CategoryDTO;
import com.example.codingbatrestfullapi.entity.Category;
import com.example.codingbatrestfullapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Category> all = categoryService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = categoryService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody CategoryDTO dto) {
        ApiResponse apiResponse = categoryService.save(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody CategoryDTO dto) {
        ApiResponse apiResponse = categoryService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = categoryService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
