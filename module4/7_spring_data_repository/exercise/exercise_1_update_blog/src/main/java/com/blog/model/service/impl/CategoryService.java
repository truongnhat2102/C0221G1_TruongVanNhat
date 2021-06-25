package com.blog.model.service.impl;

import com.blog.model.entity.Category;
import com.blog.model.repository.ICategoryRepository;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }

    @Override
    public Category findByIdCategory(long id) {
        return this.iCategoryRepository.findById(id).orElse(null);
    }
}
