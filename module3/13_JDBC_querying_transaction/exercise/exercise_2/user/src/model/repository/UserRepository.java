package model.repository;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_ALL_USER = "select * from users;";
    final String ADD = "insert into users (name, email, country)" +
            "value(?,?,?);";
    final String UPDATE = "update users" +
            " set name=?, email=?, country=?" +
            " where id=?;";

    //
    public List<User> findByAll() {
        Connection connection = baseRepository.connectDatabase();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
//

    public User getUserById(int id) {

        User user = null;

        String query = "call get_user_by_id(?);";

        // Step 1: Establishing a Connection

        try (Connection connection = baseRepository.connectDatabase();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = null;
            try {
                rs = callableStatement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // Step 4: Process the ResultSet object.

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return user;

    }


    public List<User> findAllByCallable() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = baseRepository.connectDatabase();
             CallableStatement callableStatement = connection.prepareCall("call select_user();");) {
            ResultSet rs = null;
            try {
                rs = callableStatement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    public void updateByCallable(User user) {
        Connection connection = baseRepository.connectDatabase();
        try {
            CallableStatement callableStatement = connection.prepareCall("call update_user(?,?,?,?);");
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteByCallable(int id) {
        Connection connection = baseRepository.connectDatabase();
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_user(?);");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printSQLException(SQLException e) {
        System.out.println("false");
    }

    public void insertByCallable(User user) {
        Connection conn = baseRepository.connectDatabase();
        try {
            Statement statement = conn.createStatement();
            CallableStatement callableStatement = conn.prepareCall("call insert_update(?,?,?);");
            conn.setAutoCommit(false);
            callableStatement.setString(1,user.getName());
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getCountry());
            callableStatement.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
