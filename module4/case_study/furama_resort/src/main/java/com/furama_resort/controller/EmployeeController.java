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
@RequestMapping({"/","/employee"})
public class EmployeeController {
    @Autowired
    IEmployee iEmployee;

    // list
    @GetMapping("/list-employee")
    public String showList(Model model){
        model.addAttribute("employeeList", iEmployee.findAllEmployee());
        return "/employee/list_employee";
    }

    // view
    @GetMapping("/view-employee/{id}")
    public String showEmployee(@PathVariable(value = "id") long id,
                               Model model){
        model.addAttribute("employee", iEmployee.findEmployeeById(id));
        return "/employee/view_employee";
    }

    // add
    @GetMapping(value = "/add-employee")
    public String showFormAdd(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("positionList",iEmployee.findAllPosition());
        model.addAttribute("divisionList",iEmployee.findAllDivision());
        model.addAttribute("educationDegreeList",iEmployee.findAllEducationDegree());
        return "/employee/add_employee";
    }

    @PostMapping(value = "/add-employee")
    public String addEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult){
        new EmployeeValidate().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/employee/add_employee";
        } else {
            iEmployee.save(employee);
            return "/employee/add_employee";
        }
    }

    // edit
    @GetMapping(value = "/edit-employee/{id}")
    public String showFormEdit(@PathVariable(value = "id") long id,
                               Model model){
        model.addAttribute("employee", iEmployee.findEmployeeById(id));
        model.addAttribute("positionList",iEmployee.findAllPosition());
        model.addAttribute("divisionList",iEmployee.findAllDivision());
        model.addAttribute("educationDegreeList",iEmployee.findAllEducationDegree());
        return "/employee/edit_employee";
    }

    @PatchMapping(value = "/edit-employee")
    public String editEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult){
        new EmployeeValidate().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/employee/edit_employee";
        } else {
            iEmployee.save(employee);
            return "/employee/edit_employee";
        }
    }

    // delete
    @DeleteMapping(value = "/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id,
                                 Model model){
        model.addAttribute("employee",iEmployee.findEmployeeById(id));
        iEmployee.remove(id);
        return "/list_employee";
    }

    // find by name
    @GetMapping(value = "/find-employee/{name}")
    public String showFindByName(@PathVariable(value = "name") String name,
                               Model model){
        model.addAttribute("employeeList", iEmployee.findEmployeeByName(name));
        return "/employee/list_employee";
    }
}
