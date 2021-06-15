package dictionary.controller;

import dictionary.service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionary iDictionary;

    @GetMapping(value = "/dictionary")
    public String goDictionary(){ return "dictionary"; }

    @PostMapping(value = "/dictionary")
    public String goDictionary(@RequestParam(name = "inputText") String text,
                               @RequestParam(name = "language1") int i,
                               @RequestParam(name = "language2") int j,
                               Model model){
        int instance = 0;
        if (i == 1 && j == 2){
            instance = 1;
            model.addAttribute("outputText",iDictionary.translate(text,instance));
        } else if (i == 2 && j == 1){
            instance = 2;
            model.addAttribute("outputText",iDictionary.translate(text,instance));
        } else {
            model.addAttribute("outputText",iDictionary.translate(text,instance));
        }
        return "dictionary";
    }
}
