package com.congdinh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.congdinh.repositories.ICategoryRepository;

@Controller
@RequestMapping("/manager/categories")
public class CategoryController {

    private final ICategoryRepository categoryRepository;

    // Dependency injection by constructor
    public CategoryController(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @GetMapping
    public String index(Model model) {
        var categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "manager/category/index";
    }
}
