package com.springjdbc.bootjdbcexample.dao;

import com.springjdbc.bootjdbcexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryimpl implements UserRepository {
    private static final String INSERT_USER_QUERY = "INSERT INTO users(id,first_name,last_name,email,age) values(?,?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE users SET first_name = ?, last_name=? ,email=?, age=? WHERE id = ?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getAge());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFirst_name(),user.getLast_name(),user.getEmail() ,user.getAge(),user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"), rs.getInt("age"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID_QUERY, id);
        return "user got deleted with id " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"), rs.getInt("age"));
        });
    }
}
