package com.furama_resort.controller;

import com.furama_resort.dto.CustomerValidate;
import com.furama_resort.dto.EmployeeValidate;
import com.furama_resort.model.entity.customer.Customer;
import com.furama_resort.model.repository.customer_repository.CustomerRepository;
import com.furama_resort.model.repository.customer_repository.TypeCustomerRepository;
import com.furama_resort.model.service.ICustomer;
import com.furama_resort.model.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/","/customer"})
public class CustomerController {
    @Autowired
    ICustomer iCustomer;

    // list
    @GetMapping("/list-customer")
    public String showListCustomer(Model model){
        model.addAttribute("customerList", iCustomer.findAllCustomer());
        return "/customer/list_customer";
    }

    // add
    @GetMapping("/add-customer")
    public String showAddCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeCustomerList", iCustomer.findAllType());
        return "/customer/add_customer";
    }

    @PostMapping("/add-customer")
    public String addCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        new CustomerValidate().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/add_customer";
        } else {
            iCustomer.save(customer);
            return "/customer/add_customer";
        }
    }

    // edit
    @GetMapping("/edit-customer/{id}")
    public String showEditCustomer(@PathVariable("id") long id,
                                   Model model){
        model.addAttribute("customer", iCustomer.findCustomerById(id));
        model.addAttribute("typeCustomerList", iCustomer.findAllType());
        return "/customer/edit_customer";
    }

    @PatchMapping("/edit-customer")
    public String editCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        new CustomerValidate().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit_customer";
        } else {
            iCustomer.save(customer);
            return "/customer/edit_customer";
        }
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id, Model model){
        model.addAttribute("customerDelete", iCustomer.findCustomerById(id));
        iCustomer.remove(id);
        return "/customer/delte_customer";
    }
}
