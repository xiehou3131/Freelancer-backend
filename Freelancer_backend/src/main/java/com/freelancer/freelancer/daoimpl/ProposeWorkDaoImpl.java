package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.ProposeWorkDao;
import com.freelancer.freelancer.entity.ProposeWork;
import com.freelancer.freelancer.repository.ProposeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProposeWorkDaoImpl implements ProposeWorkDao {
    @Autowired
    private ProposeWorkRepository proposeWorkRepository;

    @Override
    public ProposeWork getProWorkByPK(Integer wId, Integer uId) {
        return proposeWorkRepository.getProposeWorkByPK(wId, uId);
    }

    @Override
    public void addPropose(ProposeWork newPropose) {
        proposeWorkRepository.save(newPropose);
    }

    @Override
    public void deletePropose(ProposeWork delPropose) {
        proposeWorkRepository.delete(delPropose);
    }

}
