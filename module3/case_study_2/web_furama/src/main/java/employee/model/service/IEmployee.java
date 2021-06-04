package employee.model.service;

import employee.model.bean.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findByAll();

    Employee findById(int id);

    List<Employee> findByName(String name);

    boolean edit(Employee employee);

    boolean add(Employee employee);

    boolean remove(int id);
}
