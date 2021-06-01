package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    List<User> findByAll();

    User getUserById(int id);

    public List<User> findAllByCallable();

    public void updateByCallable(User user);

    public void deleteByCallable(int id);
}
