package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.dao.WorkDao;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.repository.WorkRepository;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
/**
* WorkDaoImpl Tester.
*
* @author <Authors name>
* @since <pre>7�� 15, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
public class WorkDaoImplTest extends FreelancerApplicationTests {
@Autowired
private WorkDao workDao;
@Autowired
private WorkRepository workRepository;

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: findByTitle(String title)
*
*/
@Test
public void testFindByTitle() throws Exception {
//TODO: Test goes here...
    List<Work> workList = new ArrayList<Work>();
    List<Work> workList1 = new ArrayList<Work>();
    workList = workDao.findByTitle("Web development");
    workList1 = workRepository.findByTitle("Web development");
    assertEquals(workList.size(), workList1.size());
}

/**
*
* Method: findByWId(Integer wId)
*
*/
@Test
public void testFindByWId() throws Exception {
//TODO: Test goes here...
    Work work = workDao.findByWId(1);
    Work work1 = workRepository.getOne(1);
    assertEquals(work.getTitle(), work1.getTitle());
}

/**
*
* Method: save(Work work)
*
*/
@Test
public void testSave() throws Exception {
//TODO: Test goes here...
    Work work = new Work();
    work.setTitle("test project");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    work.setDescription("This is a test project");
    work.setPaymentLower(20.0);
    work.setPaymentHigher(30.0);
    work.setBiddingDdl(timestamp);
    work.setFinishDdl(timestamp);
    work.setUId(1);
    workDao.save(work);
    Work work1 = workRepository.getOne(work.getW_id());
    assertEquals(work.getTitle(), work1.getTitle());
}

/**
*
* Method: getWorks(Pageable pageable)
*
*/
@Test
public void testGetWorks() throws Exception {
//TODO: Test goes here...
    Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    List<Work> workList = workDao.getWorks(pageable).getContent();
    System.out.println(workList.size());
    System.out.println(workList);
    assertEquals(workList.size(), 20);
}

/**
*
* Method: getPostedWorks(Integer uId, Pageable pageable)
*
*/
@Test
public void testGetPostedWorks() throws Exception {
//TODO: Test goes here...
    Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    List<Work> workList = workDao.getPostedWorks(62, pageable).getContent();
    System.out.println(workList.size());
    System.out.println(workList);
    assertEquals(workList.size(), 4);
}


}
