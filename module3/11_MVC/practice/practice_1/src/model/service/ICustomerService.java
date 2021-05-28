package model.service;

import model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void add(Customer customer);

    Customer findById(String id);

    void update(String id, Customer customer);

    void remove(String id);
}
