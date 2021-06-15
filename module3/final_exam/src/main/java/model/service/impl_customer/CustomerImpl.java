package model.service.impl_customer;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomer;

import java.util.List;

public class CustomerImpl implements ICustomer {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public String[] edit(Customer customer) {
        boolean flag = true;
        String msgName = "";
        String msgDateOfBirth = "";
        String msgTypeCustomer = null;
        String msgGender = "";

        if ("".equals(customer.getNameCustomer())) {
            msgName = "Please Input Name";
            flag = false;
        }
        if ("".equals(customer.getBirthday())) {
            msgDateOfBirth = "Please Input DateOfBirth";
            flag = false;
        }
        if (customer.getTypeCustomer() == null) {
            msgTypeCustomer = "Please Input Type Customer";
            flag = false;
        }
        if ("".equals(customer.getGender())) {
            msgGender = "Please Input Gender";
        }
//        if ("".equals(customer.getIdCard())){
//            msgIdCard = "Please Input idCard";
//            flag = false;
//        } else if (!customer.getIdCard().matches("[0-9]{4}")){
//            msgIdCard = "Please input like 1234";
//            flag = false;
//        }
//        if ("".equals(customer.getEmail())){
//            msgEmail = "Please Input email";
//            flag = false;
//        } else if (!customer.getIdCard().matches("[A-Za-z0-9]{1,}@[a-z]{1,}(.[a-z]){1,}")){
//            msgEmail = "Please input like abc@gmail.com";
//            flag = false;
//        }
//        if ("".equals(customer.getPhone())){
//            msgPhone = "Please Input Phone";
//            flag = false;
//        } else if (!customer.getPhone().matches("([090]||[091]||[(84)+90]||[(84)+91])([0-9]{7})")){
//            msgPhone = "Please input like 0901234567";
//            flag = false;
//        }
        if (flag) {
            flag = customerRepository.edit(customer);
        }
        return flag ? new String[]{} : new String[]{msgName, msgDateOfBirth, msgTypeCustomer, msgGender};
    }

    @Override
    public String[] add(Customer customer) {
        boolean flag = true;
        String msgName = "";
        String msgDateOfBirth = "";
        String msgTypeCustomer = null;
        String msgGender = "";

        if ("".equals(customer.getNameCustomer())) {
            msgName = "Please Input Name";
            flag = false;
        }
        if ("".equals(customer.getBirthday())) {
            msgDateOfBirth = "Please Input DateOfBirth";
            flag = false;
        }
        if (customer.getTypeCustomer() == null) {
            msgTypeCustomer = "Please Input Type Customer";
            flag = false;
        }
        if ("".equals(customer.getGender())) {
            msgGender = "Please Input Gender";
        }
//        if ("".equals(customer.getIdCard())){
//            msgIdCard = "Please Input idCard";
//            flag = false;
//        } else if (!customer.getIdCard().matches("[0-9]{4}")){
//            msgIdCard = "Please input like 1234";
//            flag = false;
//        }
//        if ("".equals(customer.getEmail())){
//            msgEmail = "Please Input email";
//            flag = false;
//        } else if (!customer.getIdCard().matches("[A-Za-z0-9]{1,}@[a-z]{1,}(.[a-z]){1,}")){
//            msgEmail = "Please input like abc@gmail.com";
//            flag = false;
//        }
//        if ("".equals(customer.getPhone())){
//            msgPhone = "Please Input Phone";
//            flag = false;
//        } else if (!customer.getPhone().matches("([090]||[091]||[(84)+90]||[(84)+91])([0-9]{7})")){
//            msgPhone = "Please input like 0901234567";
//            flag = false;
//        }
        if (flag) {
            flag = customerRepository.add(customer);
        }
        return flag ? new String[]{} : new String[]{msgName, msgDateOfBirth, msgTypeCustomer, msgGender};
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.delete(id);
    }
}
