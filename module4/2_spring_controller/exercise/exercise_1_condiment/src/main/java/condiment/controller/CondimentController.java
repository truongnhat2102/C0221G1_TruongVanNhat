package condiment.controller;

import condiment.service.impl.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;

@Controller
@RequestMapping(value = {"/","/conmediant"})
public class CondimentController {
    @Autowired
    CondimentService condimentService;

    @GetMapping(value = "/conmediant")
    public String goGet(){
        return "conmediant";
    }

    @PostMapping(value = "/conmediant")
    public String goPost(@RequestParam(name = "spices") String spices,
                         Model model){
        condimentService.saveConmediant(spices);
        model.addAttribute("message","add condiment success");
        return "conmediant";
    }
}
