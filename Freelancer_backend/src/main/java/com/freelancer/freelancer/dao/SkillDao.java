package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.Skill;

import java.util.List;

public interface SkillDao {

    Skill checkDuplicate(String skillName);

    void addSkill(Skill newSkill);

    List<Skill> getSkillsByCategory(Integer category);

}