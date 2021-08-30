package com.sprint2.employee.controller;

import com.sprint2.employee.model.entity.employee.Employee;
import com.sprint2.employee.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/employee")
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
