package com.congdinh.repositories;

import java.util.List;

import com.congdinh.entities.Category;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findById(Long id);

    void create(Category category);

    void update(Category category);

    void delete(Long id);
}
