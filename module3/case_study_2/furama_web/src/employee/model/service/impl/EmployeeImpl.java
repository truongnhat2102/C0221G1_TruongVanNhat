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
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void edit(String id, Employee employee) {
        employeeRepository.edit(id, employee);
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public void remove(String id) {
        employeeRepository.remove(id);
    }
}

