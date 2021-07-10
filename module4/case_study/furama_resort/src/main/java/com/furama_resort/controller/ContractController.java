package com.furama_resort.controller;

import com.furama_resort.model.entity.contract.Contract;
import com.furama_resort.model.service.IContract;
import com.furama_resort.model.service.ICustomer;
import com.furama_resort.model.service.IEmployee;
import com.furama_resort.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/contract","/"})
@SessionAttributes("employee")
public class ContractController {

    @Autowired
    IContract iContract;
    @Autowired
    ICustomer iCustomer;
    @Autowired
    IEmployee iEmployee;
    @Autowired
    IService iService;

    // add
    @GetMapping("/add-contract")
    public String showFormAdd(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList", iCustomer.findAllCustomer());
        model.addAttribute("employeeList", iEmployee.findAllEmployee());
        model.addAttribute("serviceList", iService.findAllService());
        return "/contract/add_contract";
    }

    @PostMapping("/add-contract")
    public String addContract(@ModelAttribute("contract") Contract contract){
        iContract.save(contract);
        return "/contract/add_contract";
    }
}
