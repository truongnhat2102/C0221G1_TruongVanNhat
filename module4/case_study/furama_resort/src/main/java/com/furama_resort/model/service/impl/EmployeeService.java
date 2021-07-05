package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.repository.EmployeeRepository;
import com.furama_resort.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployee {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        for (long i = 0; i < findAllEmployee().size(); i++) {
            if (findEmployeeById(i).getEmployeeName().contains(name)){
                employeeList.add(findEmployeeById(i));
            }
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(long id) {
        this.employeeRepository.deleteById(id);
    }
}
