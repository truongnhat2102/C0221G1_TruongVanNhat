package com.exercise_blog_app.model.service.impl;

import com.exercise_blog_app.model.entity.Blog;
import com.exercise_blog_app.model.entity.Category;
import com.exercise_blog_app.model.repository.IBlogRepository;
import com.exercise_blog_app.model.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlog {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findBlogByCategory(long idCategory) {
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < findAllBlog().size(); i++) {
            if (findAllBlog().get(i).getCategory().getIdCategory() == idCategory){
                blogList.add(findBlogById(i));
            }
        }
        return blogList;
    }
}
