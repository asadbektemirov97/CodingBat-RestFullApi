package com.example.codingbatrestfullapi.repository;

import com.example.codingbatrestfullapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
