package com.form.controller;

import com.form.dto.UserValidate;
import com.form.model.entity.User;
import com.form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    // add user
    @GetMapping(value = "/addUser")
    public String showFormAdd(Model model){
        model.addAttribute("user",new User());
        return "/addUser";
    }

    @PostMapping(value = "/addUser")
    public String add(@Validated @ModelAttribute(value = "user") User user, BindingResult bindingResult){
        new UserValidate().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/addUser";
        } else {
            iUserService.add(user);
            return "/addUser";
        }
    }
}
