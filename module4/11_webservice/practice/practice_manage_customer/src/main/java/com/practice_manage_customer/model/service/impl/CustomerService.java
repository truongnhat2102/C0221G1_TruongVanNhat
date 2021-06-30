package com.practice_manage_customer.model.service.impl;

import com.practice_manage_customer.model.entity.Customer;
import com.practice_manage_customer.model.repository.ICustomerRepository;
import com.practice_manage_customer.model.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomer {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(long id) {
        iCustomerRepository.deleteById(id);
    }
}
