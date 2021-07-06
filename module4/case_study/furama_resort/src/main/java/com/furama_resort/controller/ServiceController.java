package com.furama_resort.controller;

import com.furama_resort.model.entity.service.Service;
import com.furama_resort.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/service"})
public class ServiceController {
    @Autowired
    IService iService;

    // add
    @GetMapping("/add-service")
    public String showFormAdd(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("rentTypeList",iService.findAllRentType());
        model.addAttribute("serviceTypeList",iService.findAllServiceType());
        return "/service/add_service";
    }

    @PostMapping("/add-service")
    public String addService(@ModelAttribute("service") Service service){
        iService.save(service);
        return "/service/add_service";
    }
}
