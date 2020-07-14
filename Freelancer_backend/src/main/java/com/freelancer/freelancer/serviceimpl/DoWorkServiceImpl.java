package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.DoWorkDao;
import com.freelancer.freelancer.entity.DoWork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.freelancer.freelancer.service.DoWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoWorkServiceImpl implements DoWorkService {

    @Autowired
    private DoWorkDao doWorkDao;

    @Override
    public Page<DoWork> getWorkerWorks(Integer uId, Pageable pageable) { return doWorkDao.getWorkerWorks(uId, pageable); }

}