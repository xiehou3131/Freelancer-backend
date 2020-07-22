package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.NeedSkill;


import java.util.List;

public interface NeedSkillDao {

    List<NeedSkill> getNecessarySkillListByWId(Integer wId);

    List<NeedSkill> getUnnecessarySkillListByWId(Integer wId);

}