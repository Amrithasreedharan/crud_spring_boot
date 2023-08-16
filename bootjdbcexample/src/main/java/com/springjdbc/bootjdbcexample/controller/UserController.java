package com.springjdbc.bootjdbcexample.controller;

import com.springjdbc.bootjdbcexample.dao.UserRepository;
import com.springjdbc.bootjdbcexample.entity.User;
import com.springjdbc.bootjdbcexample.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    Service service;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {

        return service.saveUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {

        return service.updateUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {

        return service.getById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {

        return service.allUsers();
    }
    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        return service.deleteById(id);
    }

}
