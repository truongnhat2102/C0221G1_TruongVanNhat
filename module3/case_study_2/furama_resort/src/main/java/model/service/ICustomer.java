package model.service;

import model.bean.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findByAll();

    Customer findById(int id);

    List<Customer> findByName(String name);

    boolean edit(Customer customer);

    String[] add(Customer customer);

    boolean remove(int id);
}
