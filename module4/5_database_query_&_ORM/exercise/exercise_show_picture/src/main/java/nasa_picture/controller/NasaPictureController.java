package nasa_picture.controller;

import nasa_picture.model.Picture;
import nasa_picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NasaPictureController {

    @Autowired
    IPictureService iPictureService;

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("picture",new Picture());
        model.addAttribute("pictureList",iPictureService.findAll());
        return "/index";
    }

    @PostMapping(value = "/addComment")
    public String addComment(@ModelAttribute(name = "picture") Picture picture){
        iPictureService.addInteractive(picture);
        return "redirect: /index";
    }

    @GetMapping(value = "/index/like")
    public String like(@RequestParam(name = "id") int id){
        iPictureService.edit(id, iPictureService.findById(id));
        return "redirect: /index";
    }

}
