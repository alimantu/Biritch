package database.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.config.HibernateConfig;
import spring.database.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
public class UserDAOImplTest {

    @Autowired
    private UserDao userDao;

    /*@Test
    public void findAllTest() throws Exception {
        userDao.findAll().forEach(System.out::println);
        userDao.findAll();
    }*/

}