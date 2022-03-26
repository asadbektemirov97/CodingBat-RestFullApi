package com.example.codingbatrestfullapi.controller;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.entity.User;
import com.example.codingbatrestfullapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<User> all = userService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody User user) {
        ApiResponse apiResponse = userService.save(user);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody User user) {
        ApiResponse apiResponse = userService.edit(id, user);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
