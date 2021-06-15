package customers.controller;

import customers.model.Customer;
import customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/","/customers"})
    public String showList(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "customers/list";
    }
}
