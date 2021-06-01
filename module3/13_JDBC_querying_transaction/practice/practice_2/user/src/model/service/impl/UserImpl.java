package model.service.impl;

import model.bean.User;
import model.repository.BaseRepository;
import model.repository.UserRepository;
import model.service.IUser;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserImpl implements IUser {
    UserRepository userRepository = new UserRepository();
    @Override
    public List<User> findByAll() {
        return userRepository.findByAll();
    }

//    @Override
//    public User findById(int id) {
//        return userRepository.findById(id);
//    }
//
//    @Override
//    public void add(User user) {
//        userRepository.add(user);
//    }
//
//    @Override
//    public void edit(int id, User user) {
//        userRepository.edit(id, user);
//    }
//
//    @Override
//    public void delete(int id) {
//        userRepository.delete(id);
//    }
//
//    @Override
//    public List<User> sortByName() {
//        return userRepository.sortByName();
//    }
//
//    @Override
//    public List<User> searchByCountry(String find) {
//        return userRepository.findByCountry(find);
//    }
//
//    @Override
//    public User getUserById(int id) {
//        return userRepository.getUserById(id);
//    }

//    @Override
//    public void insertUserStore(User user) throws SQLException {
//        userRepository.insertUserStore(user);
//    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }

}
