package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    IUserService iUserService;

    //list
    @GetMapping(value = "/list-user")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("user/list_user");
        modelAndView.addObject("userList", this.iUserService.findAllUser(pageable));
        return modelAndView;
    }

    //create user
    @GetMapping(value = "/create-user")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("user/create_user");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("typeUserList", this.iUserService.findAllTypeUser());
        return modelAndView;
    }

    @PostMapping(value = "/create-user")
    public String add(@Valid @ModelAttribute(value = "user") UserDto userDto, BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("user", userDto);
            model.addAttribute("typeUserList", this.iUserService.findAllTypeUser());
            return "/user/create_user";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            this.iUserService.save(user);
            model.addAttribute("typeUserList", this.iUserService.findAllTypeUser());
            model.addAttribute("message", "success");
            return "/user/create_user";
        }
    }


    //edit user
    @GetMapping(value = "/edit-user/{id}")
    public ModelAndView showFormEdit(@PathVariable(value = "id") long id){
        ModelAndView modelAndView = new ModelAndView("user/edit_user");
        modelAndView.addObject("user", this.iUserService.findUserById(id));
        modelAndView.addObject("typeUserList", this.iUserService.findAllTypeUser());
        return modelAndView;
    }

    @PostMapping(value = "/edit-user")
    public String edit(@Valid @ModelAttribute(value = "user") UserDto userDto, BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("user", userDto);
            model.addAttribute("typeUserList", this.iUserService.findAllTypeUser());
            return "/user/edit_user";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            this.iUserService.save(user);
            model.addAttribute("typeUserList", this.iUserService.findAllTypeUser());
            model.addAttribute("message", "success");
            return "/user/edit_user";
        }
    }

    //delete
    @GetMapping(value = "/delete-user")
    public String deleteUser(@RequestParam(value = "idName") String id,
                             Model model){
        this.iUserService.delete(Long.parseLong(id));
        return "redirect:/list-user";
    }

    // find
}
