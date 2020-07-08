package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work,Integer> {

}