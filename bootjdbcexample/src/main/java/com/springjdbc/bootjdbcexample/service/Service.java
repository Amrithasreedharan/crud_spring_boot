package com.springjdbc.bootjdbcexample.service;

import com.springjdbc.bootjdbcexample.dao.UserRepository;
import com.springjdbc.bootjdbcexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public String deleteById(int id) {
        return userRepository.deleteById(id);
    }

    public List<User> allUsers() {
        return userRepository.allUsers();
    }

}
