package com.sprint2.employee.model.service.impl;

import com.sprint2.employee.model.entity.employee.Employee;
import com.sprint2.employee.model.respository.EmployeeRepository.EmployeeRepository;
import com.sprint2.employee.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
