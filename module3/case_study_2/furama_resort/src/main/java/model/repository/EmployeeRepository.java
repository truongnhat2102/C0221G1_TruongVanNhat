package model.repository;

import model.repository.BaseRepository;
import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;

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
    public List<Position> findAllPosition(){
        Connection connection = baseRepository.connectionDatabase();
        List<Position> positions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from positionn ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_position");
                String name = resultSet.getString("name_position");
                Position position = new Position(id,name);
                positions.add(position);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positions;
    }

    public Position findIdPosition(int id){
        Connection connection = baseRepository.connectionDatabase();
        Position position = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from positionn where id_position = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id_position");
                String name = resultSet.getString("name_position");
                position = new Position(id,name);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return position;
    }

    public List<EducationDegree> findAllEducation(){
        Connection connection = baseRepository.connectionDatabase();
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from education ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_education");
                String name = resultSet.getString("name_education");
                EducationDegree educationDegree = new EducationDegree(id,name);
                educationDegrees.add(educationDegree);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }

    public EducationDegree findIdEducation(int id){
        Connection connection = baseRepository.connectionDatabase();
        EducationDegree educationDegree = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from education where id_education = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id_education");
                String name = resultSet.getString("name_education");
                educationDegree = new EducationDegree(id,name);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegree;
    }

    public List<Division> findAllDivision(){
        Connection connection = baseRepository.connectionDatabase();
        List<Division> divisions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from part ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_part");
                String name = resultSet.getString("name_part");
                Division division = new Division(id,name);
                divisions.add(division);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }

    public Division findIdDivision(int id){
        Connection connection = baseRepository.connectionDatabase();
        Division division= null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from part where id_part = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id_part");
                String name = resultSet.getString("name_part");
                division = new Division(id,name);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return division;
    }

    public List<Employee> findByAll() {
        Connection connection = baseRepository.connectionDatabase();
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_employee");
                String name = resultSet.getString("name_employee");
                int idPosition = resultSet.getInt("id_position");
                Position position = findIdPosition(idPosition);
                int idDivision = resultSet.getInt("id_part");
                Division division = findIdDivision(idDivision);
                int idEducation = resultSet.getInt("id_education");
                EducationDegree educationDegree = findIdEducation(idEducation);
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
                employeeList.add(employee);
            }
            resultSet.close();
            preparedStatement.close();
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
                id = resultSet.getInt("id_employee");
                String name = resultSet.getString("name_employee");
                int idPosition = resultSet.getInt("id_position");
                Position position = findIdPosition(idPosition);
                int idDivision = resultSet.getInt("id_part");
                Division division = findIdDivision(idDivision);
                int idEducation = resultSet.getInt("id_education");
                EducationDegree educationDegree = findIdEducation(idEducation);
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
            }
            resultSet.close();
            preparedStatement.close();
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
                name = resultSet.getString("name_employee");
                int idPosition = resultSet.getInt("id_position");
                Position position = findIdPosition(idPosition);
                int idDivision = resultSet.getInt("id_part");
                Division division = findIdDivision(idDivision);
                int idEducation = resultSet.getInt("id_education");
                EducationDegree educationDegree = findIdEducation(idEducation);
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_person");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
                employeeList.add(employee);
            }
            resultSet.close();
            preparedStatement.close();
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
            preparedStatement.setInt(2, employee.getPosition().getIdPosition());
            preparedStatement.setInt(3, employee.getEducationDegree().getIdEducation());
            preparedStatement.setInt(4, employee.getDivision().getIdDivision());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setString(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUsername());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
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
            preparedStatement.close();
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
            preparedStatement.setInt(2, employee.getPosition().getIdPosition());
            preparedStatement.setInt(3, employee.getEducationDegree().getIdEducation());
            preparedStatement.setInt(4, employee.getDivision().getIdDivision());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setString(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUsername());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
