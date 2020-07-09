package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.UserSkillDao;
import com.freelancer.freelancer.entity.UserSkill;
import com.freelancer.freelancer.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillServiceImpl implements UserSkillService {

    @Autowired
    private UserSkillDao userSkillDao;

    @Override
    public void addUserSkill(UserSkill newUserSkill) { userSkillDao.addUserSkill(newUserSkill); }

}