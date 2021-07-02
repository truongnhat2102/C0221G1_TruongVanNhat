package com.exercise_blog.controller;

import com.exercise_blog.model.entity.Category;
import com.exercise_blog.model.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class CategoryRestController {
    @Autowired
    ICategory iCategory;

    //list category
    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> showCategories(){
        List<Category> categoryList = iCategory.findAllCategory();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
