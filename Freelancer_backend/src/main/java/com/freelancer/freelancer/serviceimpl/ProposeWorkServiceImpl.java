package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.ProposeWorkDao;
import com.freelancer.freelancer.entity.ProposeWork;
import com.freelancer.freelancer.service.ProposeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposeWorkServiceImpl implements ProposeWorkService {
    @Autowired
    private ProposeWorkDao proposeWorkDao;

    @Override
    public ProposeWork getPropseWorkByPK(Integer wId, Integer uId) {
        return proposeWorkDao.getProWorkByPK(wId, uId);
    }

    @Override
    public boolean addProposeWork(ProposeWork newProposeWork) {
        proposeWorkDao.addPropose(newProposeWork);
        return true;
    }

    @Override
    public boolean delProposeWork(ProposeWork delProposeWork) {
        proposeWorkDao.deletePropose(delProposeWork);
        return true;
    }
}
