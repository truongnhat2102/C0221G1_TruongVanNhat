package com.manage_phone.controller;

import com.manage_phone.model.entity.SmartPhone;
import com.manage_phone.model.service.ISmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/smartphones"})
public class SmartPhoneController {

    @Autowired
    ISmartPhone iSmartPhone;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        iSmartPhone.save(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public String getAllSmartphonePage(Model model) {
        model.addAttribute("smartphones", iSmartPhone.findAll());
        return "/list";
    }

    @GetMapping
    public ResponseEntity<List<SmartPhone>> allPhones() {
        return new ResponseEntity<>(iSmartPhone.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable(value = "id") Long id) {
        SmartPhone smartPhone = iSmartPhone.findById(id);
        if (smartPhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartPhone.delete(id);
        return new ResponseEntity<>(smartPhone, HttpStatus.NO_CONTENT);
    }

}
