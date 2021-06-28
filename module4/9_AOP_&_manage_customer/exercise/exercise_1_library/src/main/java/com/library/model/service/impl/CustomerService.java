package com.library.model.service.impl;

import com.library.model.entity.Customer;
import com.library.model.repository.ICustomer;
import com.library.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomer iCustomer;

    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) iCustomer.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        return iCustomer.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomer.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        iCustomer.deleteById(id);
    }
}
