package com.blog.model.service;



import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    List<Blog> findByName(String name);

    Page<Blog> findByName(Pageable pageable, String name);

    Blog findById(long id);

    void save(Blog blog);

    void delete(long id);

//    List<Category> findAllCategory();
//
//    Category findByIdCategory(long id);

}
