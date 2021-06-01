package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    List<User> findByAll();

//    User findById(int id);
//
//    void add(User user);
//
//    void edit(int id, User user);
//
//    void delete(int id);
//
//    List<User> sortByName();
//
//    List<User> searchByCountry(String find);
//
//    User getUserById(int id);
//
//    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();
}
