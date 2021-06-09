package model.repository;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActiveCustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<Customer> findCustomerActive(){
        Connection connection = baseRepository.connectionDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer " +
                    " join type_of_customer on type_of_customer.id_type_customer = customer.id_type_customer " +
                    " join contract on contract.id_customer = customer.id_customer " +
                    " join service on contract.id_service = service.id_service " +
                    " join contract_detail on contract_detail.id_contract = contract.id_contract " +
                    " left join extra_service on contract_detail.id_extra_service = extra_service.id_extra_service" +
                    " group by customer.id_customer;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name = rs.getString("name_customer");
//                String typeCustomer = rs.getString("name_type_customer");
                String birthday = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String idCard = rs.getString("id_person");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(id, name, new CustomerRepository().findByIdTypeCustomer(id), birthday, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public boolean editContract(Contract contract){
        Connection connection = baseRepository.connectionDatabase();
        PreparedStatement preparedStatement = null;
        boolean check = false;
        try {
            preparedStatement = connection.prepareStatement("update contract " +
                    "set id_service = ? " +
                    "where id_customer = ?;");
            preparedStatement.setInt(1,contract.getService().getId());
            preparedStatement.setInt(2,contract.getCustomer().getId());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
