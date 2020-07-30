package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Integer> {
    @Query("select w from Work w where w.title = ?1")
    public List<Work> findByTitle(String title);

    @Query(value = "select w from Work w where w.status=0 and w.title like %?1% and w.paymentHigher < ?2 and w.paymentLower > ?3")
    Page<Work> getWorks(String keyword, Double paymentHigher, Double paymentLower, Pageable pageable);

    @Query(value = "select w from Work w where w.u_id = ?1 and w.title like %?2% and w.paymentHigher < ?3 and w.paymentLower > ?4")
    Page<Work> getPostedWorks(Integer uId, String keyword, Double paymentHigher, Double paymentLower, Pageable pageable);

    @Query("select w from Work w where w.w_id= ?1")
    Work getAWork(Integer wId);

    @Query(value = "select w from Work w where w.w_id = ?1 and w.title like %?2% and w.paymentHigher < ?3 and w.paymentLower > ?4")
    Work findByDetails(Integer wId, String keyword, Double paymentHigher, Double paymentLower);
}
