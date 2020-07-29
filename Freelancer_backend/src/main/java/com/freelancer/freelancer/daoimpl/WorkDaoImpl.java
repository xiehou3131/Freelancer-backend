package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.entity.WorkEnclosure;
import com.freelancer.freelancer.repository.WorkEnclosureRepository;
import com.freelancer.freelancer.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkDaoImpl implements WorkDao {

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private WorkEnclosureRepository workEnclosureRepository;

    @Override
    public List<Work> findByTitle(String title) {
        List<Work> works =  workRepository.findByTitle(title);
        for (Work work : works) {
            Optional<WorkEnclosure> workEnclosure = workEnclosureRepository.findById(work.getW_id());
            if (workEnclosure.isPresent()) {
                work.setDescription(workEnclosure.get().getDescription());
            }
            else {
                work.setDescription(null);
                System.out.println("It's Null");
            }
        }
        return works;
    }

    @Override
    public Work findByWId(Integer wId) {
        Work work = workRepository.getAWork(wId);
        Optional<WorkEnclosure> workEnclosure = workEnclosureRepository.findById(wId);
        if (workEnclosure.isPresent()) {
            work.setDescription(workEnclosure.get().getDescription());
        }
        else {
            work.setDescription(null);
            System.out.println("It's Null" + wId);
        }
        return work;
    }

    @Override
    public void save(Work work) {
        WorkEnclosure workEnclosure = new WorkEnclosure(work.getW_id(), work.getDescription());
        workRepository.save(work);
        workEnclosureRepository.save(workEnclosure);
    }

    @Override
    public Page<Work> getWorks(Pageable pageable) {
        Page<Work> works = workRepository.getWorks(pageable);
        for (Work work : works) {
            Optional<WorkEnclosure> workEnclosure = workEnclosureRepository.findById(work.getW_id());
            if (workEnclosure.isPresent()) {
                work.setDescription(workEnclosure.get().getDescription());
            }
            else {
                work.setDescription(null);
                System.out.println("It's Null");
            }
        }
        return works;
    }

    @Override
    public Page<Work> getPostedWorks(Integer uId, Pageable pageable) {
        Page<Work> postedWorks = workRepository.getPostedWorks(uId, pageable);
        for (Work work : postedWorks) {
            Optional<WorkEnclosure> workEnclosure = workEnclosureRepository.findById(work.getW_id());
            if (workEnclosure.isPresent()) {
                work.setDescription(workEnclosure.get().getDescription());
            }
            else {
                work.setDescription(null);
                System.out.println("It's Null");
            }
        }
        return postedWorks;
    }

}
