package model.service.implActiceCustomer;

import model.bean.Customer;
import model.repository.ActiveCustomerRepository;
import model.repository.CustomerRepository;
import model.service.IActiveCustomer;

import java.util.List;

public class ActiveCustomerImpl implements IActiveCustomer {
    ActiveCustomerRepository activeCustomerRepository = new ActiveCustomerRepository();
    @Override
    public List<Customer> findCustomerActive() {
        return activeCustomerRepository.findCustomerActive();
    }
}
