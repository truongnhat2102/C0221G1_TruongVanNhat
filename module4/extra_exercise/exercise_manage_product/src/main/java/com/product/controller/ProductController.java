package com.product.controller;

import com.product.model.entity.Product;
import com.product.model.service.IProduct;
import com.product.model.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"","/"})
public class ProductController {
    @Qualifier("productService")
    @Autowired
    IProduct iProduct1 = new ProductService();

    @Qualifier("categoryProductService")
    @Autowired
    IProduct iProduct2;

    // list product
    @GetMapping(value = {"/list","/list/{numberpage}"})
    public String showFormList(@PageableDefault(size = 2) Pageable pageable, Model model){
        model.addAttribute("productList", iProduct1.findAll(pageable));
        return "/list";
    }

    // create product
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", iProduct2.findAll());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute(value = "product") Product product){
        iProduct1.save(product);
        return "/create";
    }

    // edit product
    @GetMapping(value = "/edit/{id}")
    public String showFormEdit(@PathVariable(value = "id") long id,
                                 Model model){
        model.addAttribute("product", iProduct1.findById(id));
        model.addAttribute("categoryList", iProduct2.findAll());
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "product") Product product){
        iProduct1.save(product);
        return "/edit";
    }

    // delete product
    @GetMapping(value = "/delete/{id}")
    public String showFormDelete(@PathVariable(value = "id") long id,
                               Model model){
        model.addAttribute("product", iProduct1.findById(id));
//        model.addAttribute("categoryList", iProduct2.findAll());
        return "/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(value = "product") Product product){
        iProduct1.remove(product.getIdProduct());
        return "/list";
    }
}
