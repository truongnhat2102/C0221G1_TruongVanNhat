package contract.model.repository;

import contract.model.bean.Contract;
import contract_detail.model.bean.ContractDetail;
import customer.model.bean.Customer;
import customer.model.service.impl.CustomerImpl;
import employee.model.bean.Employee;
import employee.model.repository.EmployeeRepository;
import employee.model.service.impl.EmployeeImpl;
import service.model.bean.Service;
import service.model.service.impl.ServiceImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<Contract> findByAll(){
        List<Contract> contractList = new ArrayList<>();
        Connection connection = baseRepository.connectionDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from contract;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idEmployee = resultSet.getInt("id_employee");
                int idCustomer = resultSet.getInt("id_customer");
                int idService = resultSet.getInt("id_service");
                String startDate = resultSet.getString("date_contract");
                String endDate = resultSet.getString("date_end");
                double deposit = resultSet.getDouble("deposit");
                double total = resultSet.getDouble("total");
                Employee employee = null;
                Customer customer = null;
                Service service = null;
                List<Employee> employeeList = new EmployeeImpl().findByAll();
                List<Customer> customerList = new CustomerImpl().findByAll();
                List<Service> serviceList = new ServiceImple().findByAll();
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getId() == idEmployee){
                        employee = employeeList.get(i);
                    }
                }
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getId() == idCustomer){
                        customer = customerList.get(i);
                    }
                }
                for (int i = 0; i < serviceList.size(); i++) {
                    if (serviceList.get(i).getId() == idService){
                        service = serviceList.get(i);
                    }
                }
                Contract contract = new Contract(1, employee, customer, service, startDate, endDate, deposit, total);
                contractList.add(contract);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    public Contract findById(int id){
        Contract contract = null;
        Connection connection = baseRepository.connectionDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from contract" +
                    " where contract.id_contract = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idEmployee = resultSet.getInt("id_employee");
                int idCustomer = resultSet.getInt("id_customer");
                int idService = resultSet.getInt("id_service");
                String startDate = resultSet.getString("date_contract");
                String endDate = resultSet.getString("date_end");
                double deposit = resultSet.getDouble("deposit");
                double total = resultSet.getDouble("total");
                Employee employee = new EmployeeImpl().findById(idEmployee);
                Customer customer = new CustomerImpl().findById(idCustomer);
                Service service = new ServiceImple().findById(idService);
                contract = new Contract(1, employee, customer, service, startDate, endDate, deposit, total);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }

    public boolean add(Contract contract){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into contract (id_employee, id_customer, id_service, date_contract, date_end, deposit, total) " +
                    "values(?,?,?,?,?,?,?);");
            preparedStatement.setInt(1,contract.getEmployee().getId());
            preparedStatement.setInt(2,contract.getCustomer().getId());
            preparedStatement.setInt(3,contract.getService().getId());
            preparedStatement.setString(4,contract.getStartDate());
            preparedStatement.setString(5,contract.getEndDate());
            preparedStatement.setDouble(6,contract.getDeposit());
            preparedStatement.setDouble(7,contract.getTotal());
            check = preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
