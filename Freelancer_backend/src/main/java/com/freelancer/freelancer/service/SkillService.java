package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.Skill;

import java.util.List;

public interface SkillService {

    Skill findById(Integer sId);

    Skill checkDuplicate(String skillName);

    void addSkill(Skill newSkill);

    List<Skill> getSkillsByCategory(Integer category);

}