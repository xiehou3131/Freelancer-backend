package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

    @Query(value = "from Skill where skillName = :skillName")
    Skill checkDuplicate(@Param("skillName") String skillName);

    @Query("select s from Skill s where s.category = ?1")
    List<Skill> getSkillsByCategory(Integer category);

}