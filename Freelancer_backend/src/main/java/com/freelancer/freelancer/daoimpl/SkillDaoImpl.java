package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.SkillDao;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDaoImpl implements SkillDao {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill checkDuplicate(String skillName) { return skillRepository.checkDuplicate(skillName); }

    @Override
    public void addSkill(Skill newSkill) { skillRepository.save(newSkill); }

}