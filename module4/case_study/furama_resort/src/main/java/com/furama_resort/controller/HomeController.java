package com.furama_resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping({"/", "/home"})
@SessionAttributes("employee")
public class HomeController {

    @GetMapping("/home")
    public String goHomeLogin(){
        return "/home";
    }
}
