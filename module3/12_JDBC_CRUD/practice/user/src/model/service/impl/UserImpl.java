package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.service.IUser;

import java.util.List;

public class UserImpl implements IUser {
    UserRepository userRepository = new UserRepository();
    @Override
    public List<User> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void edit(int id, User user) {
        userRepository.edit(id, user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public List<User> searchByCountry(String find) {
        return userRepository.findByCountry(find);
    }


}
