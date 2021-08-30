package com.furama_resort.controller;

import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.service.IEmployee;
import com.furama_resort.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping({"/","/employee"})
@SessionAttributes("employee")
public class EmployeeController {
    @Autowired
    IEmployee iEmployee;

    // list
    @GetMapping("/list-employee")
    public String showList(Model model, Principal principal){
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
        model.addAttribute("employeeList", iEmployee.findAllEmployee());
        model.addAttribute("positionList",iEmployee.findAllPosition());
        model.addAttribute("divisionList",iEmployee.findAllDivision());
        model.addAttribute("educationDegreeList",iEmployee.findAllEducationDegree());
        return "/employee/list_employee";
    }

    //403
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

    // view
    @GetMapping("/view-employee/{id}")
    public String showEmployee(@PathVariable(value = "id") long id,
                               Principal principal,
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
    public String addEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult,
                              Model model){
//        new EmployeeValidate().validate(employee, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "/employee/add_employee";
//        } else {
//            iEmployee.save(employee);
//            return "/employee/add_employee";
//        }
        iEmployee.save(employee);
        model.addAttribute("positionList",iEmployee.findAllPosition());
        model.addAttribute("divisionList",iEmployee.findAllDivision());
        model.addAttribute("educationDegreeList",iEmployee.findAllEducationDegree());
        return "/employee/add_employee";
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

    @PostMapping(value = "/edit-employee")
    public String editEmployee(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult,
                               Model model){
//        new EmployeeValidate().validate(employee, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "/employee/edit_employee";
//        } else {
//            iEmployee.save(employee);
//            return "/employee/edit_employee";
//        }
        iEmployee.save(employee);
        model.addAttribute("employee", iEmployee.findEmployeeById(employee.getEmployeeId()));
        model.addAttribute("positionList",iEmployee.findAllPosition());
        model.addAttribute("divisionList",iEmployee.findAllDivision());
        model.addAttribute("educationDegreeList",iEmployee.findAllEducationDegree());
        return "/employee/edit_employee";
    }

    // delete
    @PostMapping(value = "/delete-employee")
    public String deleteEmployee(@RequestParam(value = "idName") long id,
                                 Model model){
        iEmployee.remove(id);
        model.addAttribute("employeeList", iEmployee.findAllEmployee());
        return "/employee/list_employee";
    }

    // find by name
    @GetMapping(value = "/find-employee/{name}")
    public String showFindByName(@PathVariable(value = "name") String name,
                               Model model){
        model.addAttribute("employeeList", iEmployee.findEmployeeByName(name));
        return "/employee/list_employee";
    }

    // find by field
    @GetMapping(value = "/find-employee/field")
    public String findByField(@RequestParam(value = "field1") String field1,
                              @RequestParam(value = "field2") String field2,
                              @RequestParam(value = "field3") String field3,
                              Model model){
        String[] fields = {field1, field2, field3};
        model.addAttribute("employeeList", iEmployee.findEmployeeByField(fields));
        return "employee/list_employee";
    }
}
