package com.example.demo.controller;

import com.example.demo.model.entity.Question;
import com.example.demo.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;

    // list
    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(size = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("questionList", this.iQuestionService.findAllQuestion(pageable));
        return modelAndView;
    }

    // add
    @GetMapping(value = "/add")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("question", new Question());
        modelAndView.addObject("questionTypeList", this.iQuestionService.findAllQuestionType());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute(value = "question") Question question){
        this.iQuestionService.save(question);
        return "/add";
    }

    // edit
    @GetMapping(value = "/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable(value = "id") long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("question", this.iQuestionService.findQuestionById(id));
        modelAndView.addObject("questionTypeList", this.iQuestionService.findAllQuestionType());
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "question") Question question,
                       Model model){
        this.iQuestionService.save(question);
        model.addAttribute("question", question);
        model.addAttribute("questionTypeList", this.iQuestionService.findAllQuestionType());
        return "/edit";
    }

    //delete
    @GetMapping(value = "/delete")
    public String delete(@RequestParam("idName") long id){
        this.iQuestionService.delete(id);
        return "redirect:/list";
    }

    // view
    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable(value = "id") long id,
                       Model model){
        model.addAttribute("question", this.iQuestionService.findQuestionById(id));
        return "/view";
    }
}
