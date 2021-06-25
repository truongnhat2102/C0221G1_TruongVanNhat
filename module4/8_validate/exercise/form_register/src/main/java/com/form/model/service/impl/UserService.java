package com.form.model.service.impl;

import com.form.model.entity.User;
import com.form.model.repository.IUserRepository;
import com.form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }
}
