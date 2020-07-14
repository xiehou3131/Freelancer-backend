package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.DoWork;
import com.freelancer.freelancer.entity.DoWorkPK;
import com.freelancer.freelancer.entity.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoWorkRepository extends JpaRepository<DoWork,DoWorkPK> {

    @Query("select d from DoWork d where d.u_id = ?1")
    Page<DoWork> getWorkerWorks(Integer uId, Pageable pageable);

}