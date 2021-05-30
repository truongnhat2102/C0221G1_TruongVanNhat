package customer.model.service;

import customer.model.bean.Customer;
import sun.util.resources.cldr.chr.CalendarData_chr_US;

import java.util.List;

public interface ICustomer {
    List<Customer> findByAll();

    Customer findById(String id);

    List<Customer> findByName(String name);

    void edit(String id, Customer customer);

    void add(Customer customer);

    void remove(String id);
}
