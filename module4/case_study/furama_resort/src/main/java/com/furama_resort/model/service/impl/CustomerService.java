package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.contract.Contract;
import com.furama_resort.model.entity.customer.Customer;
import com.furama_resort.model.entity.customer.CustomerType;
import com.furama_resort.model.repository.customer_repository.CustomerRepository;
import com.furama_resort.model.repository.customer_repository.TypeCustomerRepository;
import com.furama_resort.model.service.IContract;
import com.furama_resort.model.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService implements ICustomer {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TypeCustomerRepository typeCustomerRepository;
    @Autowired
    IContract iContract;

    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for (long i = 0; i < findAllCustomer().size(); i++) {
            if (findCustomerById(i).getCustomerName().contains(name)){
                customerList.add(findCustomerById(i));
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerType> findAllType() {
        return (List<CustomerType>) typeCustomerRepository.findAll();
    }

    @Override
    public CustomerType findTypeById(long id) {
        return typeCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findActiveCustomer() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Date endDate = new Date();
        dateFormat.format(date);
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < iContract.findAllContract().size(); i++) {
            Contract contract = iContract.findAllContract().get(i);
            String endDateContract = contract.getContractEndDate();
            try {
                endDate = dateFormat.parse(endDateContract);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (endDate.after(date)){
                customerList.add(contract.getCustomer());
            }
        }
        return customerList;
    }
}
