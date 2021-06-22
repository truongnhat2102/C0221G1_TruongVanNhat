package com.blog.blog.service;

import com.blog.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(long id);

    void save(Blog blog);

    void delete(long id);

}
