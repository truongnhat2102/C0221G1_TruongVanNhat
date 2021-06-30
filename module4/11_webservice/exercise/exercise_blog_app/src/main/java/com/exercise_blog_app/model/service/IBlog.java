package com.exercise_blog_app.model.service;

import com.exercise_blog_app.model.entity.Blog;
import com.exercise_blog_app.model.entity.Category;

import java.util.List;

public interface IBlog {
    List<Blog> findAllBlog();

    Blog findBlogById(long id);

    List<Blog> findBlogByCategory(long idCategory);
}
