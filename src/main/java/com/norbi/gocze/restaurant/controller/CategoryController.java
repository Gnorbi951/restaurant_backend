package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = {"http://localhost:3000", "https://random-takeaway.netlify.app"})
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}