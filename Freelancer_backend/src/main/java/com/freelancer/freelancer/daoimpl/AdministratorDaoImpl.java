package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.AdministratorDao;
import com.freelancer.freelancer.entity.Administrator;
import com.freelancer.freelancer.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministratorDaoImpl implements AdministratorDao {

    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public Administrator checkAdmin(String name, String password) {
        return administratorRepository.checkAdmin(name, password);
    }

}
