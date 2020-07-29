package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.ProposeWork;

public interface ProposeWorkDao {
    ProposeWork getProWorkByPK(Integer wId, Integer uId);
    void addPropose(ProposeWork newPropose);
    void deletePropose(ProposeWork delPropose);
}
