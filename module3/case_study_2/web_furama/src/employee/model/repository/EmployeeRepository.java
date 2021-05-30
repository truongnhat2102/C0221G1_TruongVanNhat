package employee.model.repository;

import customer.model.bean.Customer;
import employee.model.bean.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    static Map<String, Employee> map = new HashMap<>();
    static {
        map.put("1", new Employee(1,"minh1","10/10/1997","20212154","10000","20131023","minhngokngheck","quangnam", "management", "uni", "asd", "minhngokngheck"));
        map.put("1", new Employee(1,"minh1","10/10/1997","20212154","10000","20131023","minhngokngheck","quangnam", "management", "uni", "asd", "minhngokngheck"));
        map.put("1", new Employee(1,"minh1","10/10/1997","20212154","10000","20131023","minhngokngheck","quangnam", "management", "uni", "asd", "minhngokngheck"));
        map.put("1", new Employee(1,"minh1","10/10/1997","20212154","10000","20131023","minhngokngheck","quangnam", "management", "uni", "asd", "minhngokngheck"));
        map.put("1", new Employee(1,"minh1","10/10/1997","20212154","10000","20131023","minhngokngheck","quangnam", "management", "uni", "asd", "minhngokngheck"));
    }

    public List<Employee> findByAll(){
        return new ArrayList(map.values());
    }

    public Employee findById(String id){
        return map.get(id);
    }

    public List<Employee> findByName(String name){
        List<Employee> employees = new ArrayList<>(map.values());
        List<Employee> employees1 = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().contains(name)){
                employees1.add(employees.get(i));
            }
        }
        return employees1;
    }

    public void add(Employee employee){
        map.put(String.valueOf(employee.getId()),employee);
    }

    public void remove(String id){
        map.remove(id);
    }

    public void edit(String id, Employee employee){
        map.put(id,employee);
    }
}
