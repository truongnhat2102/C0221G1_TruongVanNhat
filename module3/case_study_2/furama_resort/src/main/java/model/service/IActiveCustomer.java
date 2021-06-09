package model.service;

import model.bean.Customer;

import java.util.List;

public interface IActiveCustomer {
    List<Customer> findCustomerActive();

}
