package convert.controller;

import convert.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    IConvertService convertService;

    @GetMapping(value = "/convert_money")
    public String goHello(){
        return "convert_money";
    }

    @PostMapping(value = "/convert_money")
    public String goResult(@RequestParam(name = "moneyConvert") double moneyCovert,
                           @RequestParam(name = "currency") int i,
                           Model model){

        model.addAttribute("result",convertService.convert(moneyCovert,i));
        return "convert_money";
    }
}
