package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Work findByTitle(String title) {
        return workRepository.findByTitle(title);
    }

    @Transactional
    @Override
    public void save(Work work) {
        em.persist(work);
    }
    @PersistenceContext
    private EntityManager em;
}
