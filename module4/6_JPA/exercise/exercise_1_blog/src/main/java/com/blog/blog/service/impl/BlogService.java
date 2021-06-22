package com.blog.blog.service.impl;

import com.blog.blog.model.Blog;
import com.blog.blog.repository.IBlogRepository;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public Blog findById(long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(long id) {
        iBlogRepository.deleteById(id);
    }



}
