package com.exercise_blog_app.controller;

import com.exercise_blog_app.model.entity.Blog;
import com.exercise_blog_app.model.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/", "/blog"})
public class RestBlogController {
    @Autowired
    private IBlog iBlog;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> showListBlog(){
        List<Blog> blogList = this.iBlog.findAllBlog();

        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable(value = "id") long id){
        Blog blog = this.iBlog.findBlogById(id);

        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/blog/{idCategory}")
    public ResponseEntity<List<Blog>> showListBlogByCategory(@PathVariable(value = "idCategory") long idCategory){
        List<Blog> blogList = this.iBlog.findBlogByCategory(idCategory);

        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
