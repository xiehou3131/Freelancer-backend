package com.freelancer.freelancer;

import com.freelancer.freelancer.controller.WorkController;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web. MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
* WorkController Tester.
*
* @author zsm
* @since <pre>7�� 14, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
public class WorkControllerTest extends FreelancerApplicationTests{


private MockHttpServletRequest request;
private MockHttpServletResponse response;

@Autowired
private WorkController workController;
@Before
public void before() throws Exception {
    request = new MockHttpServletRequest();
    request.setCharacterEncoding("UTF-8");
    response = new MockHttpServletResponse();
}

@After
public void after() throws Exception {
}

/**
*
* Method: addProject(@RequestBody Map<String, String> params)
*
*/
@Test
public void testAddProject() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getWorks(@RequestBody Map<String, Integer> params)
*
*/
@Test
public void testGetWorks() throws Exception {
//TODO: Test goes here...
// How to test? How to pass the argus and get the return result
    try {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("pagenum", 1);
        m1.put("size", 20);
        System.out.println(workController.getWorks(m1));
        //assertEquals("login",loginController.loginIn(request,response)) ;
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
*
* Method: getPostedWorks(@RequestBody Map<String, Integer> params)
*
*/
@Test
public void testGetPostedWorks() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getFinishedWorks(@RequestBody Map<String, Integer> params)
*
*/
@Test
public void testGetFinishedWorks() throws Exception {
//TODO: Test goes here...
}


}
