package com.furama_resort.model.service;

import com.furama_resort.model.entity.employee.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployee {
    List<Employee> findAllEmployee();

    Employee findEmployeeById(long id);

    List<Employee> findEmployeeByName(String name);

    void save(Employee employee);

    void remove(long id);
}
