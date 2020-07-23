package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.SkillDao;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public Skill findById(Integer sId) { return skillDao.findById(sId); }

    @Override
    public Skill checkDuplicate(String skillName) { return skillDao.checkDuplicate(skillName); }

    @Override
    public void addSkill(Skill newSkill) { skillDao.addSkill(newSkill); }

    @Override
    public List<Skill> getSkillsByCategory(Integer category) { return skillDao.getSkillsByCategory(category); }

}