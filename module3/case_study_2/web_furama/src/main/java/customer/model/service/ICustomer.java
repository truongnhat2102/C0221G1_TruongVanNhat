package customer.model.service;

import customer.model.bean.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findByAll();

    Customer findById(int id);

    List<Customer> findByName(String name);

    boolean edit(Customer customer);

    boolean add(Customer customer);

    boolean remove(int id);
}
