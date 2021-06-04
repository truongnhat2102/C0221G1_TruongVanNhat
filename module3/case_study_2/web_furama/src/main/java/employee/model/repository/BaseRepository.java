package employee.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    Connection connectionDatabase(){
        final String URL = "jdbc:mysql://localhost:3306/furama_resort?allowPublicKeyRetrieval=true&useSSL=false";
        final String USER= "root";
        final String PASSWORD = "truongnhat2102";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
