package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.ProposeWork;

public interface ProposeWorkService {
    ProposeWork getPropseWorkByPK(Integer wId, Integer uId);
    boolean addProposeWork(ProposeWork newProposeWork);
    boolean delProposeWork(ProposeWork delProposeWork);
}
