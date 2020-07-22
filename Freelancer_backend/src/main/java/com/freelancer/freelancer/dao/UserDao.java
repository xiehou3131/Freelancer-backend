package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.User;

import java.util.Optional;

public interface UserDao {

    User checkUser(String name, String password);

    User checkDuplicate(String name);

    void addUser(User newUser);

    User findByName(String name);

    User findById(Integer uId);

}
