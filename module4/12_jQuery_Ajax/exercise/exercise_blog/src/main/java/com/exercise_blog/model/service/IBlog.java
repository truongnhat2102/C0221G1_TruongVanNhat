package com.exercise_blog.model.service;

import com.exercise_blog.model.entity.Blog;

import java.util.List;

public interface IBlog {
    List<Blog> findAllBlog();

    Blog findBlogById(long id);

    void save(Blog blog);

    void remove(long id);

    List<Blog> findBlogByName(String name);
}
