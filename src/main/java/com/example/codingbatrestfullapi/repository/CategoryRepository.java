package com.example.codingbatrestfullapi.repository;

import com.example.codingbatrestfullapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
