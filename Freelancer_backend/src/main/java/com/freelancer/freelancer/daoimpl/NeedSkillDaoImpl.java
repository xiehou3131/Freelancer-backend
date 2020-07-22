package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.NeedSkillDao;
import com.freelancer.freelancer.entity.NeedSkill;
import com.freelancer.freelancer.repository.NeedSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NeedSkillDaoImpl implements NeedSkillDao {

    @Autowired
    NeedSkillRepository needSkillRepository;

    @Override
    public List<NeedSkill> getNecessarySkillListByWId(Integer wId) {
        return needSkillRepository.getSkillList(wId, 1);
    }

    @Override
    public List<NeedSkill> getUnnecessarySkillListByWId(Integer wId) {
        return needSkillRepository.getSkillList(wId, 0);
    }

}