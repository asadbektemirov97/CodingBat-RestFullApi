package com.example.codingbatrestfullapi.service;

import com.example.codingbatrestfullapi.dto.ApiResponse;
import com.example.codingbatrestfullapi.entity.User;
import com.example.codingbatrestfullapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("User not found", false);
        return new ApiResponse("Mana", true, byId.get());
    }

    public ApiResponse save(User user) {
        User save = userRepository.save(user);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("Not found this user", false);
        User user1 = byId.get();
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        User save = userRepository.save(user1);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        userRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}
