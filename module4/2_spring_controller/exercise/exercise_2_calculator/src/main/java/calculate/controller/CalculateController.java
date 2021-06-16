package calculate.controller;


import calculate.service.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    ICalculate iCalculate;

    @GetMapping(value = "/calculate")
    public String goGet(){ return "calculate"; }

    @PostMapping(value = "calculate")
    public String goPost(@RequestParam(name = "num1") double num1,
                         @RequestParam(name = "num2") double num2,
                         @RequestParam(name = "sign") int sign,
                         Model model){
        model.addAttribute("result",iCalculate.calculate(num1,num2,sign));
        model.addAttribute("number1",num1);
        model.addAttribute("number2",num2);
        return "calculate";
    }
}
