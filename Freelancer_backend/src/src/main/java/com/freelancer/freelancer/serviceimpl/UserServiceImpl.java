package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String name, String password) {
        return userDao.checkUser(name, password);
    }
}
