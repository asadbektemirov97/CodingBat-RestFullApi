package com.example.codingbatrestfullapi.controller;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.dto.MarkDTO;
import com.example.codingbatrestfullapi.entity.Mark;
import com.example.codingbatrestfullapi.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
@RequiredArgsConstructor
public class MarkController {

    final MarkService markService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Mark> all = markService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = markService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody MarkDTO dto) {
        ApiResponse apiResponse = markService.save(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody MarkDTO dto) {
        ApiResponse apiResponse = markService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = markService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
