package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.NeedSkill;
import com.freelancer.freelancer.entity.NeedSkillPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NeedSkillRepository extends JpaRepository<NeedSkill, NeedSkillPK> {

    @Query("select n from NeedSkill n where n.w_id = ?1 and n.type = ?2")
    List<NeedSkill> getSkillList(Integer wId, Integer type);

}