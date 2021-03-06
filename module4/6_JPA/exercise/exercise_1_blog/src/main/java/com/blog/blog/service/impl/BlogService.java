package com.blog.blog.service.impl;

import com.blog.blog.model.Blog;
import com.blog.blog.model.Category;
import com.blog.blog.repository.IBlogRepository;
import com.blog.blog.repository.ICategoryRepository;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findByName(String name) {
        List<Blog> blogList = new ArrayList<>();
        for (long i = 0; i < findAll().size(); i++) {
            if (findById(i).getTitle().contains(name)){
                blogList.add(findById(i));
            }
        }
        return blogList;
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

    @Override
    public List<Category> findAllCategory() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    @Override
    public Category findByIdCategory(long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }


}
