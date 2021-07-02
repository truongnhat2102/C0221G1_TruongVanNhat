package com.exercise_blog.controller;

import com.exercise_blog.model.entity.Blog;
import com.exercise_blog.model.entity.Category;
import com.exercise_blog.model.service.IBlog;
import com.exercise_blog.model.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping({"/", "/blog"})
public class BlogRestController {
    @Autowired
    IBlog iBlog;


    //list blog
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> showBlogs(){
        List<Blog> blogList = iBlog.findAllBlog();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    // search
    @GetMapping("/search/{search}")
    public ResponseEntity<List<Blog>> showFindByName(@PathVariable(value = "search") String search){
        List<Blog> blogList = iBlog.findBlogByName(search);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //view
    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> showDetailBlog(@PathVariable(value = "id") long id){
        Blog blog = iBlog.findBlogById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //add
    @PostMapping
    public ResponseEntity<Blog> addBlog(@ModelAttribute("blog") Blog blog){
        iBlog.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //edit
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") long id){
        Blog blog = iBlog.findBlogById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iBlog.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable(value = "id") long id){
        Blog blog = iBlog.findBlogById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iBlog.remove(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
