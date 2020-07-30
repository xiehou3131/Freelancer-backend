package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.ProposeWork;
import com.freelancer.freelancer.entity.ProposeWorkPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProposeWorkRepository extends JpaRepository<ProposeWork, ProposeWorkPK> {
    @Query("select n from ProposeWork n where n.w_id = ?1 and n.u_id = ?2")
    ProposeWork getProposeWorkByPK(Integer wId, Integer type);

}
