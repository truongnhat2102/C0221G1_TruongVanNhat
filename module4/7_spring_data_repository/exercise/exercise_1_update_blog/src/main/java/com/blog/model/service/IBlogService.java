package com.blog.model.service;



import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;

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
