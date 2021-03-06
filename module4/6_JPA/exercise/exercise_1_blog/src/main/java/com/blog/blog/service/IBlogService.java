package com.blog.blog.service;

import com.blog.blog.model.Blog;
import com.blog.blog.model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findByName(String name);

    Blog findById(long id);

    void save(Blog blog);

    void delete(long id);

    List<Category> findAllCategory();

    Category findByIdCategory(long id);

}
