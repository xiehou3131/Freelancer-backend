package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

/**
* UserServiceImpl Tester.
*
* @author <Authors name>
* @since <pre>7�� 30, 2020</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
public class UserServiceImplTest extends FreelancerApplicationTests {
@Autowired
private UserService userService;
@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: checkUser(String name, String password)
*
*/
@Test
public void testCheckUser() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: checkDuplicate(String name)
*
*/
@Test
public void testCheckDuplicate() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: addUser(User newUser)
*
*/
@Test
public void testAddUser() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: findByName(String name)
*
*/
@Test
public void testFindByName() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: findById(Integer uId)
*
*/
@Test
public void testFindById() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: login(String name, String password)
*
*/
@Test
public void testLogin() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: changeUserStatus(User user, Integer status)
*
*/
@Test
public void testChangeUserStatus() throws Exception {
//TODO: Test goes here...
    userService.changeUserStatus(1, 1);
    User user1 = userService.findById(1);
    assertEquals(user1.getIs_banned(), 1);
}


}
