package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.ProposeWorkDao;
import com.freelancer.freelancer.entity.ProposeWork;
import com.freelancer.freelancer.repository.ProposeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProposeWorkDaoImpl implements ProposeWorkDao {

    @Autowired
    ProposeWorkRepository proposeWorkRepository;

    @Override
    public void addPropose(ProposeWork newPropose) {
        proposeWorkRepository.save(newPropose);
    }

}