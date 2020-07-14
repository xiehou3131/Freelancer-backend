package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.Administrator;

public interface AdministratorDao {

    Administrator checkAdmin(String name, String password);

}
