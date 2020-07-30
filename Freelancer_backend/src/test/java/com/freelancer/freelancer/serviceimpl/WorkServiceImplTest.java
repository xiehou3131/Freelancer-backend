package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.service.WorkService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


/**
* WorkServiceImpl Tester.
* @author <Authors name>
* @since <pre>7�� 30, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
public class WorkServiceImplTest extends FreelancerApplicationTests {

@Autowired
private WorkService workService;

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
}

/**
*
* Method: findByWId(Integer wId)
*
*/
@Test
public void testFindByWId() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: save(Work work)
*
*/
@Test
public void testSave() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getWorks(Pageable pageable)
*
*/
@Test
public void testGetWorks() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getPostedWorks(Integer uId, Pageable pageable)
*
*/
@Test
public void testGetPostedWorks() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: cancelWorkStatus(Integer u_id, Integer w_id, Integer status)
*
*/
@Test
public void testChangeWorkStatus() throws Exception {
//TODO: Test goes here...
    workService.changeWorkStatus(18,1, 2);
    assertEquals(workService.findByWId(1).getStatus(), 2);
}


}
