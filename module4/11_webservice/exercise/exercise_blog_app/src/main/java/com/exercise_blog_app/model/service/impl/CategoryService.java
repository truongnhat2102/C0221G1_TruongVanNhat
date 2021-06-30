package com.exercise_blog_app.model.service.impl;

import com.exercise_blog_app.model.entity.Category;
import com.exercise_blog_app.model.repository.ICategoryRepository;
import com.exercise_blog_app.model.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategory {

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }
}
