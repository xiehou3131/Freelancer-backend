package com.freelancer.freelancer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.controller.WorkController;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.service.DoWorkService;
import com.freelancer.freelancer.service.WorkService;
import net.sf.json.JSONString;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.nio.charset.StandardCharsets;


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

private ObjectMapper om = new ObjectMapper();

@Autowired
private WorkController workController;
@Autowired
private WorkService workService;
@Autowired
private ApplicationContext applicationContext;
@Autowired
private DoWorkService  doWorkService;

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

    mockMvc.perform(MockMvcRequestBuilders
            .post("/postWork")
            .content(obj.toString())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
}

/* getResult

 */
private String getResult(String url, String body) throws Exception{
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post(url)
            .content(body)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
    String resultContent = result.getResponse().getContentAsString();
    return resultContent;
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
    JSONObject obj = new JSONObject();
    obj.put("pagenum", 1);
    obj.put("size", 20);
    String resultContent = getResult("/getWorks", obj.toString());
    List<Work> workList = om.readValue(resultContent, new TypeReference<List<Work>>() {});
    Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    assertEquals(workService.getWorks(pageable).getContent().size(), workList.size());
}

/**
*
* Method: getPostedWorks(@RequestBody Map<String, Integer> params)
*
*/
@Test
public void testGetPostedWorks() throws Exception {
//TODO: Test goes here...
    JSONObject obj = new JSONObject();
    obj.put("pagenum", 1);
    obj.put("size", 20);
    obj.put("u_id", 1);
    String resultContent = getResult("/getPostedWorks", obj.toString());
    System.out.println(resultContent);
    List<Work> workList = om.readValue(resultContent, new TypeReference<List<Work>>() {});
    Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    assertEquals(workService.getPostedWorks(1, pageable).getContent().size(), workList.size());
}

/**
*
* Method: getFinishedWorks(@RequestBody Map<String, Integer> params)
*
*/
@Test
public void testGetFinishedWorks() throws Exception {
//TODO: Test goes here...
    JSONObject obj = new JSONObject();
    obj.put("pagenum", 1);
    obj.put("size", 20);
    obj.put("u_id", 62);

    String resultContent = getResult("/getFinishedWorks", obj.toString());
    System.out.println(resultContent);
    List<Work> workList = om.readValue(resultContent, new TypeReference<List<Work>>() {});
    Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "w_id"));
    assertEquals(doWorkService.getWorkerWorks(1, pageable).getContent().size(), workList.size());
}
}
