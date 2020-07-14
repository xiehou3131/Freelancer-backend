package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.DoWork;
import com.freelancer.freelancer.entity.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface DoWorkDao {

    Page<DoWork> getWorkerWorks(Integer uId, Pageable pageable);

}