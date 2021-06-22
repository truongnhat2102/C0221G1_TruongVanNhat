package customer.demo.repository;

import customer.demo.model.Customer;

import java.util.List;

public interface IGeneralRepository<T> {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
