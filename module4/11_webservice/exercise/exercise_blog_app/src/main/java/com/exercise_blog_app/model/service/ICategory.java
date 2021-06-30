package com.exercise_blog_app.model.service;

import com.exercise_blog_app.model.entity.Category;

import java.util.List;

public interface ICategory {
    List<Category> findAllCategory();

    Category findCategoryById(long id);
}
