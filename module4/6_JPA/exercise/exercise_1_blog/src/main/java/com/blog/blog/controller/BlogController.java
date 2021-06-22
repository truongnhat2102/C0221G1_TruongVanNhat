package com.blog.blog.controller;

import com.blog.blog.model.Blog;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"/","/list"})
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    // list
    @GetMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("blogList", iBlogService.findAll());
        return "/list";
    }

    // create
    @GetMapping(value = "/create-blog")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.save(blog);
        return "/create";
    }

    // edit
    @GetMapping(value = "/edit?id=${blog.id}")
    public String edit(@RequestParam(value = "id") Long id,
                       Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.save(blog);
        return "/edit";
    }

    //view
    @GetMapping(value = "/view?id=${blog.id}")
    public String view(@RequestParam(value = "id") long id,
                       Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/view";
    }
}
