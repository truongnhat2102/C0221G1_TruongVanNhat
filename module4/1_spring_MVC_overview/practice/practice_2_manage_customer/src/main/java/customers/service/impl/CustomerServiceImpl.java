package customers.service.impl;

import customers.model.Customer;
import customers.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        return  customers;
    }
}
