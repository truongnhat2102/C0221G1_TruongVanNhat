package com.furama_resort.controller;

import com.furama_resort.dto.EmployeeValidate;
import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployee iEmployee;

    // list
    @GetMapping("/list-employee")
    public String showList(Model model){
        model.addAttribute("employeeList", iEmployee.findAllEmployee());
        return "/list_employee";
    }

    // view
    @GetMapping("/view-employee/{id}")
    public String showEmployee(@PathVariable(value = "id") long id,
                               Model model){
        model.addAttribute("employee", iEmployee.findEmployeeById(id));
        return "/view_employee";
    }

    // add
    @GetMapping(value = "/addEmployee")
    public String showFormAdd(Model model){
        model.addAttribute("employee",new Employee());
        return "/add_employee";
    }

    @PostMapping(value = "/addEmployee")
    public String addEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult){
        new EmployeeValidate().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/addEmployee";
        } else {
            iEmployee.save(employee);
            return "/add_employee";
        }
    }

    // add
    @GetMapping(value = "/edit-employee/{id}")
    public String showFormEdit(@PathVariable(value = "id") long id,
                               Model model){
        model.addAttribute("employee", iEmployee.findEmployeeById(id));
        return "/edit_employee";
    }

    @PostMapping(value = "/edit-Employee/{id}")
    public String editEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult){
        new EmployeeValidate().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/edit_employee";
        } else {
            iEmployee.save(employee);
            return "/edit_employee";
        }
    }

    // delete
    @PostMapping(value = "/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id,
                                 Model model){
        model.addAttribute("employee",iEmployee.findEmployeeById(id));
        iEmployee.remove(id);
        return "/list_employee";
    }

    //
}
