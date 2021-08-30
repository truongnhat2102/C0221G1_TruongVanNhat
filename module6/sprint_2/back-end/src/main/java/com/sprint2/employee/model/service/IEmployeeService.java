package com.sprint2.employee.model.service;

import com.sprint2.employee.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IEmployeeService {
    Employee getEmployeeById(Long id);
    void saveEmployee(Employee employee);
}
