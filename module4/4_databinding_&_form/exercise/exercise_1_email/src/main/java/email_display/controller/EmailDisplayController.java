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

    @GetMapping(value = "/list")
    public void list(@RequestParam(name = "action") String action,
                     @RequestParam(name = "signature") String signature,
                     Model model){
        switch (action){
            case "add":
                showFormAdd();
                break;
            case "edit":
                showFormEdit(signature);
                break;
            case "detail":
                model.addAttribute("emailDisplay", emailDisplayRepository.findBySignature(signature));
                break;
            default:
                model.addAttribute("emailDisplayList", emailDisplayRepository.findByAll());
                break;
        }
    }

    @PostMapping(value = "/addDisplay")
    public void addDisplay(@RequestParam(name = "action") String action,
                           @ModelAttribute(name = "emailDisplay") EmailDisplay emailDisplay){
        switch (action){
            case "add":
                emailDisplayRepository.addDisplay(emailDisplay);
            case "edit":
                emailDisplayRepository.editDisplay(emailDisplay);
        }
    }

    public String showFormAdd(){
        return "addDisplay";
    }

    public String showFormEdit(String signature){
        Model model = null;
        model.addAttribute("emailDisplay", emailDisplayRepository.findBySignature(signature));
        return "editDisplay";
    }


}
