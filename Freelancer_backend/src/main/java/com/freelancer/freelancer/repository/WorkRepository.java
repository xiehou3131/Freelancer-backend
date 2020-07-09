package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work,Integer> {
    @Query("select w from Work w where w.title = ?1")
    public Work findByTitle(String title);

    @Query("select w from Work w")
    Page<Work> getWorks(Pageable pageable);

    @Query("select w from Work w where w.uId = ?1")
    Page<Work> getPostedWorks(Integer uId, Pageable pageable);
}
