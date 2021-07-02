package com.exercise_2_manage_phone.controller;

import com.exercise_2_manage_phone.model.entity.SmartPhone;
import com.exercise_2_manage_phone.model.service.ISmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/", "/smartphones"})
public class RestSmartPhoneController {

    @Autowired
    ISmartPhone iSmartPhone;

    // list smartphone
    @GetMapping("/smartphones")
    public ResponseEntity<List<SmartPhone>> showListSmartPhone(){
        List<SmartPhone> smartPhoneList = iSmartPhone.findAll();
        if (smartPhoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }

    // search
    @GetMapping("/search/{search}")
    public ResponseEntity<List<SmartPhone>> showFindByName(@PathVariable(value = "search") String search){
        List<SmartPhone> blogList = iSmartPhone.findByName(search);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //view
    @GetMapping("/view/{id}")
    public ResponseEntity<SmartPhone> showDetailBlog(@PathVariable(value = "id") long id){
        SmartPhone smartPhone = iSmartPhone.findById(id);
        if (smartPhone == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }

    //add
    @PostMapping
    public ResponseEntity<SmartPhone> addBlog(@ModelAttribute("smartPhone") SmartPhone smartPhone){
        iSmartPhone.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }

    //edit
    @PatchMapping("/edit/{id}")
    public ResponseEntity<SmartPhone> updateBlog(@PathVariable(value = "id") long id){
        SmartPhone smartPhone = iSmartPhone.findById(id);
        if (smartPhone == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iSmartPhone.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SmartPhone> deleteBlog(@PathVariable(value = "id") long id){
        SmartPhone smartPhone = iSmartPhone.findById(id);
        if (smartPhone == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iSmartPhone.delete(id);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }

}
