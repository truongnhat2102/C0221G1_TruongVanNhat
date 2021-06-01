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

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }


    @Override
    public List<User> findAllByCallable() {
        return userRepository.findAllByCallable();
    }

    @Override
    public void updateByCallable(User user) {
        userRepository.updateByCallable(user);
    }

    @Override
    public void deleteByCallable(int id) {
        userRepository.deleteByCallable(id);
    }


}
