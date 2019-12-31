import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wubing.ssm_pro.dao.UserDao;
import wubing.ssm_pro.domain.UserInfo;
import wubing.ssm_pro.service.UserService;

@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService service;
    @Test
    public void testFindByUsername() throws Exception {
        UserInfo tom = userDao.findByUsername("tom");
        System.out.println(tom);
        System.out.println("///////////////");
        service.loadUserByUsername("tom");
    }
}
