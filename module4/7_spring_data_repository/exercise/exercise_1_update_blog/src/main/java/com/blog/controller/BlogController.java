package com.blog.controller;


import com.blog.model.entity.Blog;
import com.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"","/list"})
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
    public String showFormCreate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iBlogService.findAllCategory());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.save(blog);
        return "/create";
    }

    // edit
    @GetMapping(value = "/edit/{id}")
    public String showFormEdit(@PathVariable(name = "id") long id,
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
    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable(value = "id") long id,
                       Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/views";
    }

    //delete
    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(value = "blog") Blog blog){
        iBlogService.delete(blog.getId());
        return "/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String showFormDelete(@PathVariable(value = "id") long id,
                                 Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/delete";
    }

    //find by name
    @GetMapping(value = "/findByName")
    public String findByName(@RequestParam String find,
                             Model model){
        model.addAttribute("blogList",iBlogService.findByName(find));
        return "/list";
    }
}
