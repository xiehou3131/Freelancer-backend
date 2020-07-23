package com.freelancer.freelancer.daoimpl;

import com.freelancer.freelancer.dao.AdministratorDao;
import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.entity.Administrator;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.repository.AdministratorRepository;
import com.freelancer.freelancer.service.AdministratorService;
import com.freelancer.freelancer.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/** 
* AdministratorDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>7�� 15, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorDaoImplTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private AdministratorDao administratorDao;

    @Autowired
    private AdministratorService administratorService;

    @MockBean
    private AdministratorRepository administratorRepository;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: checkAdmin(String name, String password)
    *
    */
    @Test
    public void testCheckAdmin() throws Exception {
        Administrator admin = new Administrator();
        admin.setAId(1);
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setPowerLevel(1);

        when(administratorRepository.checkAdmin("admin", "admin")).thenReturn(admin);
        assertEquals(admin, administratorDao.checkAdmin("admin","admin"));
    }


} 
