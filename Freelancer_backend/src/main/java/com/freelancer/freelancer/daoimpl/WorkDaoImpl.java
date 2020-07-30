package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class WorkDaoImpl implements WorkDao {
    @Autowired
    private WorkRepository workRepository;

    @Override
    public List<Work> findByTitle(String title) {
        return workRepository.findByTitle(title);
    }

    @Override
    public Work findByWId(Integer wId) {
        return workRepository.getAWork(wId);
    }

    @Transactional
    @Override
    public void save(Work work) {
        workRepository.save(work);
    }

    @Override
    public Page<Work> getWorks(Pageable pageable) {
        Page<Work> works = workRepository.getWorks(pageable);
        return works;
    }

    @Override
    public Page<Work> getPostedWorks(Integer uId, Pageable pageable) {
        Page<Work> postedWorks = workRepository.getPostedWorks(uId, pageable);
        return postedWorks;
    }

}
