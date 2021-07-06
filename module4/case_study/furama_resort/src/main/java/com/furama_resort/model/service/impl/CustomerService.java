package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.customer.Customer;
import com.furama_resort.model.repository.CustomerRepository;
import com.furama_resort.model.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomer {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for (long i = 0; i < findAllCustomer().size(); i++) {
            if (findCustomerById(i).getCustomerName().contains(name)){
                customerList.add(findCustomerById(i));
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(long id) {
        this.customerRepository.deleteById(id);
    }
}
