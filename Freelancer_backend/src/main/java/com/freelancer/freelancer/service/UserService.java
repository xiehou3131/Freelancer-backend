package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.User;

import java.util.List;


public interface UserService {

    User checkUser(String name, String password);

    User checkDuplicate(String name);

    void addUser(User newUser);

    User findByName(String name);

}