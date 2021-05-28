package model.repository;

import model.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    static Map<String, Customer> map = new HashMap<>();

    static {
        map.put("1", new Customer("1", "John", "john@codegym.vn", "Hanoi"));
        map.put("2", new Customer("2", "Bill", "bill@codegym.vn", "Danang"));
        map.put("3", new Customer("3", "Alex", "alex@codegym.vn", "Saigon"));
        map.put("4", new Customer("4", "Adam", "adam@codegym.vn", "Beijin"));
        map.put("5", new Customer("5", "Sophia", "sophia@codegym.vn", "Miami"));
        map.put("6", new Customer("6", "Rose", "rose@codegym.vn", "Newyork"));
    }

    public List<Customer> findByAll() {
        // kết nối databe=> lấy lại cái danh sách
        return new ArrayList<>(map.values());
    }

    public Customer findById(String id) {
        return map.get(id);
    }

    public void update(String id, Customer customer) {
        map.put(id,customer);
    }
    public void add(String id,Customer customer) {
        map.put("id",customer);
    }

    public void remove(String id) {
        map.remove("id");
    }
}
