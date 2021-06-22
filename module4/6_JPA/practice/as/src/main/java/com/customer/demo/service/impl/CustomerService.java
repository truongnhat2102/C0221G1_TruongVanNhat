package com.customer.demo.service.impl;

import com.customer.demo.model.Customer;
import com.customer.demo.repository.IGeneralRepository;
import com.customer.demo.repository.impl.CustomerRepository;
import com.customer.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {

    private IGeneralRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
