package com.example.demo.controller;

import com.example.demo.model.entity.Employee;
import com.example.demo.model.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/employee")
public class EmployeeController {
    private IEmployeeService iEmployeeService;

    @PostMapping(value = "/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        iEmployeeService.add(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
    }
}
