package com.springjdbc.bootjdbcexample.controller;

import com.springjdbc.bootjdbcexample.dao.UserRepository;
import com.springjdbc.bootjdbcexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {

        return userRepository.saveUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {

        return userRepository.updateUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {

        return userRepository.getById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {

        return userRepository.allUsers();
    }
    @DeleteMapping("/deletecountry/{id}")
    public String updateCountry(@PathVariable(value = "id") int id){
        return userRepository.deleteById(id);
    }

}
