package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.FreelancerApplicationTests;
import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.repository.UserRepository;
import com.freelancer.freelancer.service.UserService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * UserDaoImpl Tester.
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
public class UserDaoImplTest extends FreelancerApplicationTests {

        @Test
        public void contextLoads() {
        }

        @Autowired
        private UserDao userDao;

        @Autowired
        private UserService userService;

        @MockBean
        private UserRepository userRepository;

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
                User user = new User();
                user.setU_id(1);
                user.setName("a2atech1");
                user.setPassword("123456");
                user.setPhone("18201740079");
                user.setE_mail("xxqhjw@sjtu.edu.cn");
                user.setTrue_name("a2atech1");
                user.setCredit_card("111-222-333");
                user.setType(1);
                user.setIs_banned(0);

                when(userRepository.checkUser("a2atech1", "123456")).thenReturn(user);
                assertEquals(user, userDao.checkUser("a2atech1", "123456"));
        }

        /**
         *
         * Method: checkDuplicate(String name)
         *
         */
        @Test
        public void testCheckDuplicate() throws Exception {
                User user = new User();
                user.setU_id(1);
                user.setName("a2atech1");
                user.setPassword("123456");
                user.setPhone("18201740079");
                user.setE_mail("xxqhjw@sjtu.edu.cn");
                user.setTrue_name("a2atech1");
                user.setCredit_card("111-222-333");
                user.setType(1);
                user.setIs_banned(0);

                when(userRepository.checkDuplicate("a2atech1")).thenReturn(user);
                assertEquals(user, userDao.checkDuplicate("a2atech1"));
        }

        /**
         *
         * Method: addUser(User newUser) user.setU_id(1); user.setName("a2atech1");
         * user.setPassword("123456"); user.setPhone("18201740079");
         * user.setEMail("xxqhjw@sjtu.edu.cn"); user.setTrueName("a2atech1");
         * user.setCreditCard("111-222-333"); user.setType(1); user.setIsBanned(0);
         * ======= user.setE_mail("xxqhjw@sjtu.edu.cn"); user.setTrue_name("a2atech1");
         * user.setCredit_card("111-222-333"); user.setType(1); user.setIs_banned(0);
         * 
         * userDao.addUser(user); verify(userRepository, times(1)).save(user); }
         * 
         * /**
         *
         * Method: findByName(String name)
         *
         */
        @Test
        public void testFindByName() throws Exception {
                User user = new User();
                user.setU_id(1);
                user.setName("a2atech1");
                user.setPassword("123456");
                user.setPhone("18201740079");
                user.setE_mail("xxqhjw@sjtu.edu.cn");
                user.setTrue_name("a2atech1");
                user.setCredit_card("111-222-333");
                user.setType(1);
                user.setIs_banned(0);

                when(userRepository.findByName("a2atech1")).thenReturn(user);
                assertEquals(user, userDao.findByName("a2atech1"));
        }

}
