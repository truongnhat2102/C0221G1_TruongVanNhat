package com.blog.controller;


import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import com.blog.model.service.IBlogService;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    IBlogService iBlogService;
    ICategoryService iCategoryService;

    // list
    @GetMapping(value = {"/list",""})
    public String list(Model model,
                       @PageableDefault(size = 2) Pageable pageable){
        Page<Blog> page = iBlogService.findAll(pageable);
        model.addAttribute("blogList", page);
        return "/list";
    }

    // create blog
    @GetMapping(value = "/create-blog")
    public String showFormCreate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.save(blog);
        return "/create";
    }

    // create category
    @GetMapping(value = "/create-category")
    public String showFormCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "/create_category";
    }

    @PostMapping(value = "/create")
    public String createCategory(@ModelAttribute(name = "category") Category category){
        iCategoryService.save(category);
        return "/create_category";
    }

    // edit blog
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

    //delete blog
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

    //delete category
    @PostMapping(value = "/delete-category")
    public String deleteCategory(@ModelAttribute(value = "category") Category category){
        iCategoryService.delete(category.getIdCategory());
        return "/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String showFormDeleteCategory(@PathVariable(value = "id") long id,
                                 Model model){
        model.addAttribute("category", iCategoryService.findByIdCategory(id));
        return "/delete_category";
    }

    //find by name
    @GetMapping(value = "/findByName")
    public String findByName(@RequestParam String find,
                             Model model){
        model.addAttribute("blogList",iBlogService.findByName(find));
        return "/list";
    }
}
