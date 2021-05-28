package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findByAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer.getId(),customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(String id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.remove(id);
    }
}
