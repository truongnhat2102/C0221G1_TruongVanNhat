package com.exercise_blog.model.service.impl;

import com.exercise_blog.model.entity.Blog;
import com.exercise_blog.model.repository.IBlogRepository;
import com.exercise_blog.model.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlog {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public Blog findBlogById(long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findBlogByName(String name) {
        List<Blog> blogList = new ArrayList<>();
        for (long i = 0; i < findAllBlog().size(); i++) {
            if ((findBlogById(i).getTittle()).contains(name)){
                blogList.add(findBlogById(i));
            }
        }
        return blogList;
    }
}
