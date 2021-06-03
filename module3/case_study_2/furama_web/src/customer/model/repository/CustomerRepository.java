package customer.model.repository;

import customer.model.bean.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<Customer> findByAll() {
        Connection connection = baseRepository.connectionDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("call find_by_all();");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name = rs.getString("name_customer");
                String typeCustomer = rs.getString("name_type_customer");
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(id, name, typeCustomer, birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public Customer findById(int id) {
        Connection connection = baseRepository.connectionDatabase();
        Customer customer = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("call find_by_id(?);");
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()) {
                int id_customer = rs.getInt("id_customer");
                String nameCustomer = rs.getString("name_customer");
                String typeCustomer = rs.getString("name_type_customer");
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id_customer, nameCustomer, typeCustomer, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public List<Customer> findByName(String name){
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.connectionDatabase();
        Customer customer = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("call find_by_name(?);");
            ResultSet rs = callableStatement.executeQuery();
            callableStatement.setString(1,"%"+name+"%");
            while(rs.next()) {
                int id = rs.getInt("id_customer");
                String nameCustomer = rs.getString("name_customer");
                String typeCustomer = rs.getString("name_type_customer");
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, nameCustomer, typeCustomer, birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public boolean add(Customer customer){
        Connection connection = baseRepository.connectionDatabase();
        CallableStatement callableStatement = null;
        boolean check =false;
        try {
            callableStatement = connection.prepareCall("call insert_customer(?,?,?,?,?,?,?,?);");
            callableStatement.setInt(1,customer.getIdType());
            callableStatement.setString(2,customer.getName());
            callableStatement.setString(3,customer.getDateOfBirth());
            callableStatement.setString(4,customer.getGender());
            callableStatement.setString(5,customer.getIdCard());
            callableStatement.setString(6,customer.getPhone());
            callableStatement.setString(7,customer.getEmail());
            callableStatement.setString(8,customer.getAddress());
            callableStatement.executeUpdate();
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean remove(int id){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_customer(?);");
            callableStatement.executeUpdate();
            callableStatement.setInt(1,id);
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean edit(Customer customer){
        Connection connection = baseRepository.connectionDatabase();
        CallableStatement callableStatement = null;
        boolean check =false;
        try {
            callableStatement = connection.prepareCall("call update_customer(?,?,?,?,?,?,?,?,?);");
            callableStatement.setInt(1,customer.getId());
            callableStatement.setInt(2,customer.getIdType());
            callableStatement.setString(3,customer.getName());
            callableStatement.setString(4,customer.getDateOfBirth());
            callableStatement.setString(5,customer.getGender());
            callableStatement.setString(6,customer.getIdCard());
            callableStatement.setString(7,customer.getPhone());
            callableStatement.setString(8,customer.getEmail());
            callableStatement.setString(9,customer.getAddress());
            callableStatement.executeUpdate();
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
