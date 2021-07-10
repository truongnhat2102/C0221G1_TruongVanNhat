package com.furama_resort.model.repository.login;

import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.entity.employee.User;
import com.furama_resort.model.repository.ILogin;
import com.furama_resort.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILogin {

    @Autowired
    IEmployee iEmployee;

    public Employee doLogin(User user){
        for (int i = 0; i < iEmployee.findAllEmployee().size(); i++) {
            Employee employee = iEmployee.findAllEmployee().get(i);
            if (employee.getUser().getUsername().equals(user.getUsername()) && employee.getUser().getPassword().equals(user.getPassword())){
                return employee;
            }
        }
        return null;
    }
}
