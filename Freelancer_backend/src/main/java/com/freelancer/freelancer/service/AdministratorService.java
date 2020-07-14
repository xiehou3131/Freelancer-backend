package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.Administrator;


public interface AdministratorService {

    Administrator checkAdmin(String name, String password);

}
