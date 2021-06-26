package com.blog.model.service;

import com.blog.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    List<Category> findByName(String name);

    Category findByIdCategory(long id);

    void save(Category category);

    void delete(long id);
}
