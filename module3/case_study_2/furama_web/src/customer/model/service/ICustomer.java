package customer.model.service;

import customer.model.bean.Customer;
import sun.util.resources.cldr.chr.CalendarData_chr_US;

import java.util.List;

public interface ICustomer {
    List<Customer> findByAll();

    Customer findById(int id);

    List<Customer> findByName(String name);

    boolean edit(Customer customer);

    boolean add(Customer customer);

    boolean remove(int id);
}
