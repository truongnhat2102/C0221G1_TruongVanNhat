package com.manage_customer.model.service;

import com.manage_customer.model.entity.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findAll();

    Customer findById(long id);

    void add(Customer customer);

    void edit(long id, Customer customer);

    void delete(long id);
}
