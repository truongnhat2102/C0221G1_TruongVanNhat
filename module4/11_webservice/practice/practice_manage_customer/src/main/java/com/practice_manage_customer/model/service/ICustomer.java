package com.practice_manage_customer.model.service;

import com.practice_manage_customer.model.entity.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findAll();

    Customer findById(long id);

    void save(Customer customer);

    void remove(long id);
}
