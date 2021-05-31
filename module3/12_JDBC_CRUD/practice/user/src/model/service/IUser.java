package model.service;

import model.bean.User;

import java.util.List;

public interface IUser {
    List<User> findByAll();

    User findById();

    List<User> findByName();

    void add();

    void edit();

    void delete();
}
