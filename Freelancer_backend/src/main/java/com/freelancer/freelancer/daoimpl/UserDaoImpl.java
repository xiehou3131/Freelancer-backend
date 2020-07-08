package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public User checkUser(String name, String password) {
        return userRepository.checkUser(name, password);
    }

    @Override
    public User checkDuplicate(String name) { return userRepository.checkDuplicate(name); }

    @Override
    public void addUser(User newUser) { userRepository.save(newUser); }

}
