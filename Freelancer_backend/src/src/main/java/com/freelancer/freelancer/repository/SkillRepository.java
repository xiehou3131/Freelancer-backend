package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

}