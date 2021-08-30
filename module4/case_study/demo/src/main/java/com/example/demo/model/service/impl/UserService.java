package com.example.demo.model.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.TypeUser;
import com.example.demo.model.entity.User;
import com.example.demo.model.repository.ITypeUserRepository;
import com.example.demo.model.repository.IUserRepository;
import com.example.demo.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    ITypeUserRepository iTypeUserRepository;

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return this.iUserRepository.findAll(pageable);
    }

    @Override
    public User findUserById(long id) {
        return this.iUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<TypeUser> findAllTypeUser() {
        return (List<TypeUser>) this.iTypeUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(long id) {
        iUserRepository.deleteById(id);
    }
}
