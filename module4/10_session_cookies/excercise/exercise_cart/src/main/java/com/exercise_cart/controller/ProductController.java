package com.exercise_cart.controller;
import com.exercise_cart.model.entity.Cart;
import com.exercise_cart.model.entity.Product;
import com.exercise_cart.model.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProduct productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = Optional.ofNullable(productService.findById(id));
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
//        if (action.equals("show")) {
//            cart.addProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
        cart.addProduct(productOptional.get(id));
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id, @ModelAttribute Cart cart){
        cart.deleteProduct(id);
        return "redirect:/cart";
    }
}
