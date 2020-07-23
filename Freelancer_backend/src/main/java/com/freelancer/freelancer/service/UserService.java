package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.utils.msgutils.Msg;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;

import java.util.List;

public interface UserService {

    User checkUser(String name, String password);

    User checkDuplicate(String name);

    void addUser(User newUser);

    User findByName(String name);

    User findById(Integer uId);

    Msg login(String name, String password);

}