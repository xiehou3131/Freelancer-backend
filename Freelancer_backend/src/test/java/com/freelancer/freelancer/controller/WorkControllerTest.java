package com.freelancer.freelancer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.controller.WorkController;
import net.sf.json.JSONString;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web. MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* WorkController Tester.
*
* @author zsm
* @since <pre>7�� 14, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkControllerTest extends FreelancerApplicationTests {

private MockMvc mockMvc;

@Autowired
private WebApplicationContext context;

private ObjectMapper om;

@Autowired
private WorkController workController;
@Autowired
private ApplicationContext applicationContext;

@Before
public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
}

@After
public void after() throws Exception {
}

/**
*
* Method: addProject(@RequestBody Map<String, String> params)
*
*/

public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test
public void testAddProject() throws Exception {
//TODO: Test goes here...
    JSONObject obj = new JSONObject();
    obj.put("title", "test project2");
    obj.put("description", "This is a test case");
    obj.put("uId", 1);
    obj.put("paymentLower", 20.1);
    obj.put("paymentHigher", 20.3);
    obj.put("biddingDdl", "2020-7-17");
    obj.put("finishDdl", "2020-7-24");
//    String string = JSON.toJSONString(obj, SerializerFeature.BrowserCompatible);
//    System.out.println(obj);
//    String str = om.writeValueAsString(obj);
//    System.out.println(str);
    mockMvc.perform(MockMvcRequestBuilders
            .post("/postWork")
            .content(obj.toString())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
            //.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
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
