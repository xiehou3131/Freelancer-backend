package com.freelancer.freelancer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.controller.UserController;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * UserController Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * 7�� 15, 2020
 *        </pre>
 * 
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends FreelancerApplicationTests {
    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     * Method: login(@RequestBody Map<String, String> params)
     *
     */
    @Test
    public void testLogin() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("name", "a2atech1");
        obj.put("password", "123456");

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/login").content(obj.toString())
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // .andExpect(jsonPath("$.data").value("test"))
                .andExpect(content().json("{status:0}"))
                .andExpect(content().json("{data:{\"name\":\"a2atech1\",\"userType\":1}}")).andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

    /**
     *
     * Method: logout()
     *
     */
    @Test
    public void testLogout() throws Exception {
        // TODO: Test goes here...
    }

    /**
     *
     * Method: addUser(@RequestBody Map<String, String> params)
     *
     */
    @Test
    public void testAddUser() throws Exception {
        // TODO: Test goes here...
    }

    /**
     *
     * Method: checkSession()
     *
     */
    @Test
    public void testCheckSession() throws Exception {
        // TODO: Test goes here...
    }

    /**
     *
     * Method: getUserInfo(@RequestBody Map<String, String> params)
     *
     */
    @Test
    public void testGetUserInfo() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("name", "a2atech1");

        mockMvc.perform(MockMvcRequestBuilders.post("/getUserInfo").content(obj.toString())
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.u_id").value(1)).andExpect(jsonPath("$.phone").value("18201740079"))
                .andExpect(jsonPath("$.e_mail").value("xxqhjw@sjtu.edu.cn"))
                .andExpect(jsonPath("$.credit_card").value("111-222-333")).andReturn();
    }

}
