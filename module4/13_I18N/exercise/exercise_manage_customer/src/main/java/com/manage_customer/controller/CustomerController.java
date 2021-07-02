package com.manage_customer.controller;

import com.manage_customer.model.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/add")
    public String addNewCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "/list";
    }
}
