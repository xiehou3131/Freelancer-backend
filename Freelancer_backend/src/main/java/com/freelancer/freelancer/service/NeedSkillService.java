package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.NeedSkill;
import com.freelancer.freelancer.entity.Skill;
import java.util.List;


public interface NeedSkillService {

    List<Integer> getNecessarySkillListByWId(Integer wId);

    List<Integer> getUnnecessarySkillListByWId(Integer wId);

}