package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.ProposeWork;
import com.freelancer.freelancer.entity.ProposeWorkPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProposeWorkRepository extends JpaRepository<ProposeWork, ProposeWorkPK> {

}