package com.library.model.service;

import com.library.model.entity.Book;
import com.library.model.entity.Customer;

import java.util.List;

public interface ICustomerService {

    // customer
    List<Customer> findAllCustomer();
    Customer findCustomerById(long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(long id);



}
