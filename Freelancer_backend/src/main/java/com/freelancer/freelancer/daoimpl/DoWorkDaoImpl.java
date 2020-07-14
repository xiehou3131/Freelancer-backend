package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.DoWorkDao;
import com.freelancer.freelancer.entity.DoWork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.freelancer.freelancer.repository.DoWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoWorkDaoImpl implements DoWorkDao {

    @Autowired
    DoWorkRepository doWorkRepository;

    @Override
    public Page<DoWork> getWorkerWorks(Integer uId, Pageable pageable) { return doWorkRepository.getWorkerWorks(uId, pageable); }

}