package com.freelancer.freelancer;

import com.freelancer.freelancer.FreelancerApplication;
import com.freelancer.freelancer.dao.DoWorkDao;
import com.freelancer.freelancer.repository.DoWorkRepository;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* DoWorkDaoImpl Tester.
*
* @author <Authors name>
* @since <pre>7�� 17, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
public class DoWorkDaoImplTest extends FreelancerApplicationTests {
@Autowired
private DoWorkRepository doWorkRepository;
@Autowired
private DoWorkDao doWorkDao;
@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: getWorkerWorks(Integer uId, Pageable pageable)
*
*/
@Test
public void testGetWorkerWorks() throws Exception {
//TODO: Test goes here...
    Pageable pageable = PageRequest.of( 0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    assertEquals(doWorkRepository.getWorkerWorks(6, pageable).getContent().size(), doWorkDao.getWorkerWorks(6, pageable).getContent().size());
}
}
