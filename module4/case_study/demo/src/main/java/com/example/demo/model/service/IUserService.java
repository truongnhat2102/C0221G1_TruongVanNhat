package com.example.demo.model.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.TypeUser;
import com.example.demo.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAllUser(Pageable pageable);

    User findUserById(long id);

    List<TypeUser> findAllTypeUser();

    void save(User user);

    void delete(long id);
}
