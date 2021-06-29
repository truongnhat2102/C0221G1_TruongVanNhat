package com.practice_1_count_view.controller;


import com.practice_1_count_view.model.entity.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("counter")
public class CountController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}
