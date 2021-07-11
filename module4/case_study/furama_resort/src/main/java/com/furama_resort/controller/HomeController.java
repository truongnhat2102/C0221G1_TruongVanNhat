package com.furama_resort.controller;

import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.entity.employee.User;
import com.furama_resort.model.repository.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping({"/", "/home"})
@SessionAttributes("employee")
public class HomeController {

    @GetMapping("/home")
    public String goHomeLogin(){
        return "/home";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "home";
    }

    @Autowired
    ILogin iLogin;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showFormLogin(Model model){
        return "/login";
    }

//    @PostMapping(value = "/login")
//    public String loginWithSession(@ModelAttribute(value = "user") User user, BindingResult bindingResult,
//                                   @RequestParam(value = "remember",required = false) boolean check,
//                                   Model model,
//                                   @CookieValue(value = "setUsername", defaultValue = "") String setUsername,
//                                   @CookieValue(value = "setPassword", defaultValue = "") String setPassword,
//                                   HttpServletResponse response, HttpServletRequest request){
//        model.addAttribute("booleanVariable", true);
//        Employee employee = iLogin.doLogin(user);
//        if (check){
//            if (employee != null){
//                setUsername = user.getUsername();
//                setPassword = user.getPassword();
//                Cookie cookieUsername = new Cookie("setUsername", setUsername);
//                Cookie cookiePassword = new Cookie("setPassword", setPassword);
//                cookieUsername.setMaxAge(365*24*60*60);
//                cookiePassword.setMaxAge(365*24*60*60);
//                response.addCookie(cookieUsername);
//                response.addCookie(cookiePassword);
//
//                Cookie[] cookies = request.getCookies();
//
//                model.addAttribute("setUsernameValue", cookies[0]);
//                model.addAttribute("setPasswordValue", cookies[1]);
//                return "/home";
//            } else {
//                model.addAttribute("message", "login failed");
//                return "/login";
//            }
//        } else {
//            if (employee != null){
//                model.addAttribute("employee", employee);
//                return "/home";
//            } else {
//                model.addAttribute("message", "login failed");
//                return "/login";
//            }
//        }
//
//    }
}
