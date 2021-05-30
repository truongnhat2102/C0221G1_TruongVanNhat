package employee.model.service;

import customer.model.bean.Customer;
import employee.model.bean.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findByAll();

    Employee findById(String id);

    List<Employee> findByName(String name);

    void edit(String id, Employee employee);

    void add(Employee employee);

    void remove(String id);
}
