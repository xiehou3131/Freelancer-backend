package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.User;
import java.util.List;

public interface UserDao {

    User checkUser(String name, String password);

}
