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
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public void edit(String id, Customer customer) {
        customerRepository.edit(id, customer);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.remove(id);
    }
}
