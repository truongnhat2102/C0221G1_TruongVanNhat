package customer.model.service.impl;

import customer.model.bean.Customer;
import customer.model.repository.CustomerRepository;
import customer.model.service.ICustomer;

import java.util.List;

public class CustomerImpl implements ICustomer {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public boolean edit(Customer customer) {
        return customerRepository.edit(customer);
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }
}
