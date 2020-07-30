package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.service.WorkService;
import net.sf.json.JSONObject;
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
    public List<Work> findByTitle(String title) {
        return workDao.findByTitle(title);
    }

    @Override
    public Work findByWId(Integer wId) {
        return workDao.findByWId(wId);
    }

    @Override
    public void save(Work work) {
        workDao.save(work);
    }

    @Override
    public Page<Work> getWorks(Pageable pageable) { return workDao.getWorks(pageable); }

    @Override
    public Page<Work> getPostedWorks(Integer uId, Pageable pageable, String keyword, Double paymentHigher,
            Double paymentLower) {
        return workDao.getPostedWorks(uId, pageable, keyword, paymentHigher, paymentLower);
    }

    @Override
    public boolean changeWorkStatus(Integer u_id, Integer w_id, Integer status) {
        Work work = workDao.findByWId(w_id);
        if (u_id != work.getU_id()) {
            return false;
        } else {
            work.setStatus(status);
            workDao.save(work);
            return true;
        }
    }
}
