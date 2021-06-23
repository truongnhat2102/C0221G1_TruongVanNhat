package email_display.controller;

import email_display.model.EmailDisplay;
import email_display.repository.EmailDisplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.UnrecoverableEntryException;

@Controller
@RequestMapping(value = "/email_display")
public class EmailDisplayController {
    @Autowired
    EmailDisplayRepository emailDisplayRepository;
    
    //list
    @GetMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("emailDisplayList", emailDisplayRepository.findByAll());
        return "/list";
    }

    //view
    @GetMapping(value = "/view(signature=product.getId())")
    public String view(@RequestParam(name = "signature") String signature,
                       Model model){
        model.addAttribute("emailDisplay", emailDisplayRepository.findBySignature(signature));
        return "/view(signature=product.getId())";
    }

    // add
    @GetMapping(value = "/addDisplay")
    public String showFormAdd(){
        return "addDisplay";
    }

    @PostMapping(value = "/addDisplay")
    public String add(@ModelAttribute(name = "emailDisplay") EmailDisplay emailDisplay){
        emailDisplayRepository.addDisplay(emailDisplay);
        return "redirect: /addDisplay";
    }

    // edit
    @GetMapping(value = "/editDisplay")
    public String showFormEdit(String signature){
        Model model = null;
        model.addAttribute("emailDisplay", emailDisplayRepository.findBySignature(signature));
        return "/editDisplay";
    }
    @PostMapping(value = "/editDisplay")
    public String edit(@ModelAttribute(name = "emailDisplay") EmailDisplay emailDisplay){
        emailDisplayRepository.editDisplay(emailDisplay);
        return "redirect: /editDisplay";
    }


}
