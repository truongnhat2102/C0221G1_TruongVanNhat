package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.employee.Division;
import com.furama_resort.model.entity.employee.EducationDegree;
import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.entity.employee.Position;
import com.furama_resort.model.repository.employee_repository.DivisionRepository;
import com.furama_resort.model.repository.employee_repository.EducationDegreeRepository;
import com.furama_resort.model.repository.employee_repository.EmployeeRepository;
import com.furama_resort.model.repository.employee_repository.PositionRepository;
import com.furama_resort.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployee {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        for (long i = 0; i < findAllEmployee().size(); i++) {
            if (findEmployeeById(i).getEmployeeName().contains(name)){
                employeeList.add(findEmployeeById(i));
            }
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Division> findAllDivision() {
        return (List<Division>) divisionRepository.findAll();
    }

    @Override
    public Division findDivisionById(long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Position> findAllPosition() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public Position findPositionById(long id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return (List<EducationDegree>) educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findEducationDegreeById(long id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee findEmployeeByUsername(String username, String password) {
        Employee employee = null;
        for (int i = 0; i < findAllEmployee().size(); i++) {
            if (findAllEmployee().get(i).getUser().getUsername().equals(username)){
                if (findAllEmployee().get(i).getUser().getPassword().equals(password)){
                    employee = findAllEmployee().get(i);
                    break;
                }
                break;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeeByField(String[] fields) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < findAllEmployee().size(); i++) {
            Employee employee = findAllEmployee().get(i);
            long positionId = employee.getPosition().getPositionId();
            long divisionId = employee.getDivision().getDivisionId();
            long educationDegreeId = employee.getEducationDegree().getEducationDegreeId();
            if (positionId == Integer.parseInt(fields[0]) && divisionId == Integer.parseInt(fields[1]) && educationDegreeId == Integer.parseInt(fields[2])){
                employeeList.add(employee);
            } else if (positionId == Integer.parseInt(fields[0]) && divisionId == Integer.parseInt(fields[1])){
                employeeList.add(employee);
            } else if (positionId == Integer.parseInt(fields[0]) && educationDegreeId == Integer.parseInt(fields[2])) {
                employeeList.add(employee);
            } else if (educationDegreeId == Integer.parseInt(fields[2]) && divisionId == Integer.parseInt(fields[1])) {
                employeeList.add(employee);
            } else if (positionId == Integer.parseInt(fields[0]) || divisionId == Integer.parseInt(fields[1]) || educationDegreeId == Integer.parseInt(fields[2])){
                employeeList.add(employee);
            }
        }
        if (employeeList.isEmpty()){
            return findAllEmployee();
        }
        return employeeList;
    }
}
