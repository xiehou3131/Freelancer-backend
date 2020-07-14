package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.AdministratorDao;
import com.freelancer.freelancer.entity.Administrator;
import com.freelancer.freelancer.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public Administrator checkAdmin(String name, String password) {
        return administratorDao.checkAdmin(name, password);
    }

}
