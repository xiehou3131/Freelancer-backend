package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;

    @Override
    public Work findByTitle(String title) {
        return workDao.findByTitle(title);
    }

    @Override
    public void save(Work work) {
        workDao.save(work);
    }

    @Override
    public Page<Work> getWorks(Pageable pageable) { return workDao.getWorks(pageable); }

    @Override
    public Page<Work> getPostedWorks(Integer uId, Pageable pageable) { return workDao.getPostedWorks(uId, pageable); }
}
