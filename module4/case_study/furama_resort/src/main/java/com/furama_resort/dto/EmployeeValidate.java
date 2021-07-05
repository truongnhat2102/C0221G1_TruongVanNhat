package com.furama_resort.dto;

import com.furama_resort.model.entity.employee.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

public class EmployeeValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeValidate.class.isAssignableFrom(clazz);
    }

    public int getAgeCustomer(String birthday){
        Date date = new Date();
        int year=date.getYear()+1900;
        int yearDay = Integer.parseInt(birthday.split("/")[1]);
        int age = year - yearDay;
        return age;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        String name = employee.getEmployeeName();
        String birthday = employee.getEmployeeBirthday();
        String idCard = employee.getEmployeeIdCard();
        double salary = employee.getEmployeeSalary();
        String phone = employee.getEmployeePhone();
        String email = employee.getEmployeeEmail();
        String address = employee.getEmployeeAddress();

        // validate name
        ValidationUtils.rejectIfEmpty(errors, "employeeName", "employeeName.empty");
        if (name.matches("([A-Z][a-z]{1,})")){
            errors.rejectValue("employeeName", "employeeName.match","enter like Abcd");
        }

        // validate phone
        ValidationUtils.rejectIfEmpty(errors, "employeePhone", "employeePhone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("employeePhone", "employeePhone.length", "enter right length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("employeePhone", "employeePhone.startsWith", "start with number 0");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("employeePhone", "employeePhone.matches", "just phone number");
        }

        // validate idCard
        ValidationUtils.rejectIfEmpty(errors, "employeeIdCard", "employeeIdCard.empty");
        if (email.matches("[0-9]{9}")){
            errors.rejectValue("employeeIdCard", "employeeIdCard.match","enter like 123456789");
        }

        // validate email
        ValidationUtils.rejectIfEmpty(errors, "employeeEmail", "employeeEmail.empty");
        if (email.matches("[A-Za-z0-9]{6,}@gmail[.]com")){
            errors.rejectValue("employeeEmail", "employeeEmail.match","enter like Abc123@gmail.com");
        }

        // validate age
        ValidationUtils.rejectIfEmpty(errors, "employeeBirthday", "employeeBirthday.empty");
        if (this.getAgeCustomer(birthday)<18){
            errors.rejectValue("employeeBirthday", "employeeBirthday.match","age >= 18");
        }
    }
}
