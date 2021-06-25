package com.form.dto;

import com.form.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserValidate.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        int age = user.getAge();
        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        if (firstName.matches("([A-Z][a-z]{1,})")){
            errors.rejectValue("firstName", "firstName.match","enter like Abcd");
        }
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        if (lastName.matches("([A-Z][a-z]{1,})")){
            errors.rejectValue("lastName", "lastName.match","enter like Abcd");
        }
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (phoneNumber.length()>11 || phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length", "enter right length");
        }
        if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith", "start with number 0");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches", "just phone number");
        }
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age<18){
            errors.rejectValue("age", "age.min","enter age 18+");
        }
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (email.matches("[A-Za-z0-9]{6,}@gmail[.]com")){
            errors.rejectValue("email", "email.match","enter like Abc123@gmail.com");
        }
    }
}
