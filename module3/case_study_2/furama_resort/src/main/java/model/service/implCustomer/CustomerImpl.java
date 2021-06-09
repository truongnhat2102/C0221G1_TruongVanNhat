package model.service.implCustomer;

import model.bean.Customer;
import model.common.validate.Validate;
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
    public boolean edit(Customer customer) {
        return customerRepository.edit(customer);
    }

    @Override
    public String[] add(Customer customer) {
        boolean flag = true;
        String msgName = "";
        String msgDateOfBirth = "";
        String msgIdCard = "";
        String msgPhone = "";
        String msgEmail = "";
        String msgAddress = "";
        if ("".equals(customer.getName())){
            msgName = "Please Input Name";
            flag = false;
        }
        if ("".equals(customer.getDateOfBirth())){
            msgDateOfBirth = "Please Input DateOfBirth";
            flag = false;
        }
        if ("".equals(customer.getIdCard())){
            msgIdCard = "Please Input idCard";
            flag = false;
        } else if (!customer.getIdCard().matches("[0-9]{4}")){
            msgIdCard = "Please input like 1234";
            flag = false;
        }
        if ("".equals(customer.getEmail())){
            msgEmail = "Please Input email";
            flag = false;
        } else if (!customer.getIdCard().matches("[A-Za-z0-9]{1,}@[a-z]{1,}(.[a-z]){1,}")){
            msgEmail = "Please input like abc@gmail.com";
            flag = false;
        }
        if ("".equals(customer.getPhone())){
            msgPhone = "Please Input Phone";
            flag = false;
        } else if (!customer.getPhone().matches("([090]||[091]||[(84)+90]||[(84)+91])([0-9]{7})")){
            msgPhone = "Please input like 0901234567";
            flag = false;
        }
        if (flag){
            flag = customerRepository.add(customer);
        }
        return flag? new String[]{} : new String[]{msgName,msgDateOfBirth, msgIdCard, msgEmail, msgPhone};
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }
}
