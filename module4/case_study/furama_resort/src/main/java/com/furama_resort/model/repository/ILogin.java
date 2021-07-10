package com.furama_resort.model.repository;

import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.entity.employee.User;

public interface ILogin {
    Employee doLogin(User user);
}
