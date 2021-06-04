package employee.model.repository;

import employee.model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    static final String ADD =
            " insert into employee(name_employee, id_position, id_education, id_part, date_of_birth, id_person, salary, phone, email, address, username)" +
            " values(?,?,?,?,?,?,?,?,?,?,?);"
            ;

    public List<Employee> findByAll() {
        Connection connection = baseRepository.connectionDatabase();
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee " +
                    "join positionn on positionn.id_position = employee.id_position \n" +
                    "join education on education.id_education = employee.id_education \n" +
                    "join part on part.id_part = employee.id_part;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_employee");
                String name = resultSet.getString("name_employee");
                String position = resultSet.getString("name_position");
                String part = resultSet.getString("name_part");
                String education = resultSet.getString("name_education");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, part, username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public Employee findById(int id) {
        Connection connection = baseRepository.connectionDatabase();
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee " +
                    "join positionn on positionn.id_position = employee.id_position \n" +
                    "join education on education.id_education = employee.id_education \n" +
                    "join part on part.id_part = employee.id_part \n" +
                    "where employee.id_employee = ?;");
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_employee");
                String position = resultSet.getString("name_position");
                int idPosition = resultSet.getInt("id_position");
                String part = resultSet.getString("name_part");
                int idDivision = resultSet.getInt("id_part");
                String education = resultSet.getString("name_education");
                int idDegree = resultSet.getInt("id_education");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                employee = new Employee( id,  name,  birthday,  idCard,  salary,  phone,  email,  address,  position,  idPosition,  education,  idDegree,  part,  idDivision,  username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public List<Employee> findByName(String name) {
        Connection connection = baseRepository.connectionDatabase();
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee " +
                    "join positionn on positionn.id_position = employee.id_position \n" +
                    "join education on education.id_education = employee.id_education \n" +
                    "join part on part.id_part = employee.id_part \n " +
                    "having employee.name_employee like ?;");
            preparedStatement.setString(1, '%' + name + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_employee");
                String name_employee = resultSet.getString("name_employee");
                String position = resultSet.getString("name_position");
                String part = resultSet.getString("name_part");
                String education = resultSet.getString("name_education");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name_employee, birthday, idCard, salary, phone, email, address, position, education, part, username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public boolean add(Employee employee) {
        Connection connection = baseRepository.connectionDatabase();
        boolean check = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);


            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getIdPosition());
            preparedStatement.setInt(3, employee.getIdDegree());
            preparedStatement.setInt(4, employee.getIdDivision());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setString(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUsername());
            check = preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean remove(int id) {
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete employee.* from employee where employee.id_employee = ?;");

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean edit( Employee employee) {
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SET SQL_SAFE_UPDATES = 0;\n" +
                    "    SET foreign_key_checks = 0; \n" +
                    "    \n" +
                    "\tupdate customer \n" +
                    "    set name_employee = ?,\n" +
                    "    id_position = ?,\n" +
                    "    id_education = ?,\n" +
                    "\t id_part = ?,\n" +
                    "    date_of_birth = ?,\n" +
                    "    id_person = ?,\n" +
                    "    salary = ?,\n" +
                    "    phone = ?,\n" +
                    "    email = ?,\n" +
                    "    address = ?,\n" +
                    "    username = ?\n" +
                    "    where customer.id_customer = ?;\n" +
                    "    \n" +
                    "    SET foreign_key_checks = 1; \n" +
                    "    SET SQL_SAFE_UPDATES = 1;");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getIdPosition());
            preparedStatement.setInt(3, employee.getIdDegree());
            preparedStatement.setInt(4, employee.getIdDivision());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setString(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getId());
            preparedStatement.executeUpdate();
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
