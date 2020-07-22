package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.NeedSkillDao;
import com.freelancer.freelancer.entity.DoWork;
import com.freelancer.freelancer.entity.NeedSkill;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.service.NeedSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NeedSkillServiceImpl implements NeedSkillService {

    @Autowired
    private NeedSkillDao needSkillDao;

    @Override
    public List<Integer> getNecessarySkillListByWId(Integer wId) {
        List<NeedSkill> needSkills = needSkillDao.getNecessarySkillListByWId(wId);
        List<Integer> needSkillList = new ArrayList<>();
        for (NeedSkill needSkill : needSkills) {
            needSkillList.add(needSkill.getS_id());
        }
        return needSkillList;
    }

    @Override
    public List<Integer> getUnnecessarySkillListByWId(Integer wId) {
        List<NeedSkill> needSkills = needSkillDao.getUnnecessarySkillListByWId(wId);
        List<Integer> needSkillList = new ArrayList<>();
        for (NeedSkill needSkill : needSkills) {
            needSkillList.add(needSkill.getS_id());
        }
        return needSkillList;
    }

}