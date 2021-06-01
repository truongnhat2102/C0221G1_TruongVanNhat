package model.repository;

import model.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_ALL_USER = "select * from users;";
//    final String SELECT_BY_ID = "select * from users;\n" +
//            "where id=?;";
    final String ADD = "insert into users (name, email, country)" +
            "value(?,?,?);";
//    final String DELETE = "delete users.* from users " +
//            "where users.id=?;";
//    final String UPDATE = "update users" +
//            " set name=?, email=?, country=?" +
//            " where id=?;";
//    final String SELECT_BY_COUNTRY = "select * from users" +
//            " where users.country like ?;";
//    final String SORT_BY_NAME = "select * from users" +
//            " order by users.name;";
//
    public List<User> findByAll(){
        Connection connection = baseRepository.connectDatabase();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name,email,country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
//
//    public User findById(int id){
//        Connection connection = baseRepository.connectDatabase();
//        User user = new User();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                String country = resultSet.getString("country");
//                user = new User(id,name,email,country);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return user;
//    }
//
//    public void add(User user){
//        Connection connection = baseRepository.connectDatabase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2,user.getEmail());
//            preparedStatement.setString(3,user.getCountry());
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void delete(int id){
//        Connection connection = baseRepository.connectDatabase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
//            preparedStatement.setInt(1,id);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void edit(int id, User user){
//        Connection connection = baseRepository.connectDatabase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2,user.getEmail());
//            preparedStatement.setString(3,user.getCountry());
//            preparedStatement.setInt(4,id);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public List<User> findByCountry(String find){
//        List<User> userList = new ArrayList<>();
//        Connection connection = baseRepository.connectDatabase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_COUNTRY);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            preparedStatement.setString(1,'%'+find+'%');
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                String country = resultSet.getString("country");
//                User user = new User(name,email,country);
//                userList.add(user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return userList;
//    }
//
//    public List<User> sortByName(){
//        Connection connection = baseRepository.connectDatabase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
//            preparedStatement.executeQuery();
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return findByAll();
//    }
//
//    public void insertUserStore(User user){
//        String query = "call insert_user(?,?,?);";
//
//        // try-with-resource statement will auto close the connection.
//
//        try (Connection connection = baseRepository.connectDatabase();
//
//             CallableStatement callableStatement = connection.prepareCall(query);) {
//
//            callableStatement.setString(1, user.getName());
//
//            callableStatement.setString(2, user.getEmail());
//
//            callableStatement.setString(3, user.getCountry());
//
//            System.out.println(callableStatement);
//
//            callableStatement.executeUpdate();
//
//        } catch (SQLException e) {
//
//            printSQLException(e);
//
//        }
//
//    }
//
//    public User getUserById(int id) {
//
//        User user = null;
//
//        String query = "call get_user_by_id(?);";
//
//        // Step 1: Establishing a Connection
//
//        try (Connection connection = baseRepository.connectDatabase();
//
//             // Step 2:Create a statement using connection object
//
//             CallableStatement callableStatement = connection.prepareCall(query);) {
//
//            callableStatement.setInt(1, id);
//
//            // Step 3: Execute the query or update query
//
//            ResultSet rs = null;
//            try {
//                rs = callableStatement.executeQuery();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//            // Step 4: Process the ResultSet object.
//
//            while (rs.next()) {
//
//                String name = rs.getString("name");
//
//                String email = rs.getString("email");
//
//                String country = rs.getString("country");
//
//                user = new User(id, name, email, country);
//
//            }
//
//        } catch (SQLException e) {
//
//            printSQLException(e);
//
//        }
//
//        return user;
//
//    }

    public void addUserTransaction(User user, int[] permisions) {
        Connection conn = null;
        // for insert a new user
        PreparedStatement pstmt = null;
        // for assign permision to user
        PreparedStatement pstmtAssignment = null;
        // for getting user id
        ResultSet rs = null;
        try {
            conn = baseRepository.connectDatabase();
            // set auto commit to false
            conn.setAutoCommit(false);
            //
            // Insert user
            //
            pstmt = conn.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();
            // get user id
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next())
                userId = rs.getInt(1);
            //
            // in case the insert operation successes, assign permision to user
            //
            if (rowAffected == 1) {
                // assign permision to user
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                pstmtAssignment = conn.prepareStatement(sqlPivot);
                for (int permisionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }

        } catch (SQLException ex) {
            // roll back the transaction
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void printSQLException(SQLException e) {
        System.out.println("false");
    }

//    public static void main(String[] args) {
//        User user = new User("nhat","truongnhat","hue");
//        UserRepository userRepository = new UserRepository();
//        userRepository.sortByName();
////       userRepository.add(user);
////       userRepository.delete(1);
////        userRepository.edit(2,user);
//    }
}
