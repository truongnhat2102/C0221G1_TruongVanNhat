package com.exercise_blog.model.service;

import com.exercise_blog.model.entity.Category;

import java.util.List;

public interface ICategory {
    List<Category> findAllCategory();

    Category findCategoryById(long id);
}
