package model.repository;

import model.repository.BaseRepository;
import model.bean.Customer;
import model.bean.TypeCustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<TypeCustomer> findAllTypeCustomer(){
        Connection connection = baseRepository.connectionDatabase();
        List<TypeCustomer> typeCustomers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type_of_customer;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_type_customer");
                String nameType = resultSet.getString("name_type_customer");
                TypeCustomer typeCustomer = new TypeCustomer(id, nameType);
                typeCustomers.add(typeCustomer);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeCustomers;
    }

    public TypeCustomer findByIdTypeCustomer(int id){
        Connection connection = baseRepository.connectionDatabase();
        TypeCustomer typeCustomer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type_of_customer  " +
                    " where type_of_customer.id_type_customer = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nameType = resultSet.getString("name_type_customer");
                typeCustomer = new TypeCustomer(id, nameType);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeCustomer;
    }

    public List<Customer> findByAll() {
        Connection connection = baseRepository.connectionDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("call find_by_all();");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name = rs.getString("name_customer");
                int idTypeCustomer = rs.getInt("id_type_customer");
                TypeCustomer typeCustomer = findByIdTypeCustomer(idTypeCustomer);
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(id, name, typeCustomer, birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            rs.close();
            callableStatement.close();
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
                int idTypeCustomer = rs.getInt("id_type_customer");
                TypeCustomer typeCustomer = findByIdTypeCustomer(idTypeCustomer);
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id_customer, nameCustomer, typeCustomer, birthday, gender, idCard, phone, email, address);
            }
            rs.close();
            callableStatement.close();
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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer where customer.name_customer like ?;");
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id_customer");
                String nameCustomer = rs.getString("name_customer");
                int idTypeCustomer = rs.getInt("id_type_customer");
                TypeCustomer typeCustomer = findByIdTypeCustomer(idTypeCustomer);
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, nameCustomer, findByIdTypeCustomer(id), birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            rs.close();
            preparedStatement.close();
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
            callableStatement.setInt(1,customer.getTypeCustomer().getIdTypeCustomer());
            callableStatement.setString(2,customer.getName());
            callableStatement.setString(3,customer.getDateOfBirth());
            callableStatement.setString(4,customer.getGender());
            callableStatement.setString(5,customer.getIdCard());
            callableStatement.setString(6,customer.getPhone());
            callableStatement.setString(7,customer.getEmail());
            callableStatement.setString(8,customer.getAddress());
            callableStatement.executeUpdate();
            check = true;
            callableStatement.close();
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
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
            check = true;
            callableStatement.close();
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
            callableStatement.setInt(2,(customer.getTypeCustomer()).getIdTypeCustomer());
            callableStatement.setString(3,customer.getName());
            callableStatement.setString(4,customer.getDateOfBirth());
            callableStatement.setString(5,customer.getGender());
            callableStatement.setString(6,customer.getIdCard());
            callableStatement.setString(7,customer.getPhone());
            callableStatement.setString(8,customer.getEmail());
            callableStatement.setString(9,customer.getAddress());
            callableStatement.executeUpdate();
            check = true;
            callableStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
        new CustomerRepository().findByName("asd");
    }
}
