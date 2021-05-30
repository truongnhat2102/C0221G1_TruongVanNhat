package customer.model.repository;

import customer.model.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    static Map<String, Customer> map = new HashMap<>();
    static {
        map.put("1", new Customer(1,"minh1","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
        map.put("2", new Customer(2,"minh2","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
        map.put("3", new Customer(3,"minh3","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
        map.put("4", new Customer(4,"minh4","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
        map.put("5", new Customer(5,"minh5","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
        map.put("6", new Customer(6,"minh6","diamond","10/10/1997","men","20131023","minhngokngheck","quangnam"));
    }
    public List<Customer> findByAll(){
        return new ArrayList<>(map.values());
    }

    public Customer findById(String id){
        return map.get(id);
    }

    public List<Customer> findByName(String name){
        List<Customer> customers = new ArrayList<>(map.values());
        List<Customer> customers1 = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name)){
                customers1.add(customers.get(i));
            }
        }
        return customers1;
    }

    public void add(Customer customer){
        map.put(String.valueOf(customer.getId()),customer);
    }

    public void remove(String id){
        map.remove(id);
    }

    public void edit(String id, Customer customer){
        map.put(id,customer);
    }
}
