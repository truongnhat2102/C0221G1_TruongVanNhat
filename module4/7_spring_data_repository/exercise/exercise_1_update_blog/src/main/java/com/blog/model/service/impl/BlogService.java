package com.blog.model.service.impl;


import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import com.blog.model.repository.IBlogRepository;
import com.blog.model.repository.ICategoryRepository;
import com.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    ICategoryRepository iCategoryRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

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
    public Page<Blog> findByName(Pageable pageable, String name) {
        return null;
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

//    @Override
//    public List<Category> findAllCategory() {
//        return (List<Category>) iCategoryRepository.findAll();
//    }
//
//    @Override
//    public Category findByIdCategory(long id) {
//        return iCategoryRepository.findById(id).orElse(null);
//    }


}
