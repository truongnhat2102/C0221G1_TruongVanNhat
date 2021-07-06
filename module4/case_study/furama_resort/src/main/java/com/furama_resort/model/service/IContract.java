package com.furama_resort.model.service;

import com.furama_resort.model.entity.contract.Contract;
import com.furama_resort.model.entity.customer.Customer;
import com.furama_resort.model.entity.employee.Employee;
import com.furama_resort.model.entity.service.Service;

import java.util.List;

public interface IContract {
    void save(Contract contract);
}
