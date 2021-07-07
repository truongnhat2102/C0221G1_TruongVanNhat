package com.furama_resort.model.service;

import com.furama_resort.model.entity.customer.Customer;
import com.furama_resort.model.entity.customer.CustomerType;
import com.furama_resort.model.entity.employee.Employee;

import java.util.List;

public interface ICustomer {
    List<Customer> findAllCustomer();

    Customer findCustomerById(long id);

    List<Customer> findCustomerByName(String name);

    void save(Customer customer);

    void remove(long id);

    List<CustomerType> findAllType();

    CustomerType findTypeById(long id);

    List<Customer> findActiveCustomer();
}
