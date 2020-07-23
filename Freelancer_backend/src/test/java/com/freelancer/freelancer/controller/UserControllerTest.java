package com.freelancer.freelancer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.controller.UserController;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>7�� 15, 2020</pre> 
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
//        JSONObject data = new JSONObject();
//        data.put(Constant.NAME, user.getName());
//        data.put(Constant.USER_TYPE, user.getType());
//        SessionUtil.setSession(data);
//
//        return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
    }

    /**
    *
    * Method: logout()
    *
    */
    @Test
    public void testLogout() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: addUser(@RequestBody Map<String, String> params)
    *
    */
    @Test
    public void testAddUser() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: checkSession()
    *
    */
    @Test
    public void testCheckSession() throws Exception {
    //TODO: Test goes here...
    }


} 
