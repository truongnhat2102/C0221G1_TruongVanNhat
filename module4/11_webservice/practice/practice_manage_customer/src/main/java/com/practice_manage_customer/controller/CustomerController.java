package com.practice_manage_customer.controller;

import com.practice_manage_customer.model.entity.Customer;
import com.practice_manage_customer.model.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ICustomer iCustomer;

    @GetMapping
    public ResponseEntity<List<Customer>> getListCustomer(){
        List<Customer> customerList = this.iCustomer.findAll();

        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") long id){
        Customer customer = this.iCustomer.findById(id);

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> saveCustomer(@ModelAttribute Customer customer){
        iCustomer.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long id){
        Customer customer = iCustomer.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customer.getId());
        iCustomer.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "id") long id){
        Customer customer = iCustomer.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customer.getId());
        iCustomer.remove(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
