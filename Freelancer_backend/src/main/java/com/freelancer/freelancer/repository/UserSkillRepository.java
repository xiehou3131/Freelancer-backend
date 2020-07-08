package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.UserSkill;
import com.freelancer.freelancer.entity.UserSkillPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkill,UserSkillPK> {

}