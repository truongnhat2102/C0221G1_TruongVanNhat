package convert.controller;

import convert.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ConvertController {
    @Autowired
    IConvertService convertService;

    @GetMapping(value = "/hello_spring")
    public String goHello(){
        return "hello_spring";
    }

    @PostMapping(value = "/hello_spring")
    public String goResult(@RequestParam(name = "moneyConvert") double moneyCovert,
                           @RequestParam(name = "currency") int i,
                           Model model){
        double currency = 1;
        switch (i){
            case 1:
                currency = 0.00004347826;
                break;
            case 2:

                currency = 23000;
                break;
            default:
                currency = 1;
                break;
        }
        model.addAttribute("result",convertService.convert(moneyCovert,currency));
        return "hello_spring";
    }
}
