package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.Skill;

public interface SkillDao {

    Skill checkDuplicate(String skillName);

    void addSkill(Skill newSkill);

}