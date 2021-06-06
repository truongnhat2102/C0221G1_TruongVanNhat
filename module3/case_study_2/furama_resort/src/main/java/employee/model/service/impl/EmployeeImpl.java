package employee.model.service.impl;

import employee.model.bean.Employee;
import employee.model.repository.EmployeeRepository;
import employee.model.service.IEmployee;

import java.util.List;

public class EmployeeImpl implements IEmployee {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findByAll() {
        return employeeRepository.findByAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public boolean edit(Employee employee) {
        return employeeRepository.edit(employee);
    }

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }

    @Override
    public boolean remove(int id) {
        return employeeRepository.remove(id);
    }
}

