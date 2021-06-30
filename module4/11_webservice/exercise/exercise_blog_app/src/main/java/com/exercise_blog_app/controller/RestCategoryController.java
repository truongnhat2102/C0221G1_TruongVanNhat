package com.exercise_blog_app.controller;

import com.exercise_blog_app.model.entity.Blog;
import com.exercise_blog_app.model.entity.Category;
import com.exercise_blog_app.model.service.IBlog;
import com.exercise_blog_app.model.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/", "/category"})
public class RestCategoryController {
    @Autowired
    private ICategory iCategory;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showListBlog(){
        List<Category> categoryList = this.iCategory.findAllCategory();

        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> showBlog(@PathVariable(value = "id") long id){
        Category category = this.iCategory.findCategoryById(id);

        if (category == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
