import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wubing.ssm_pro.dao.RoleDao;
import wubing.ssm_pro.domain.Permission;
import wubing.ssm_pro.domain.Role;

import java.util.List;

@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRole {
    private RoleDao roleDao;
    @Test
    public void test_findRoleByUserId() throws Exception {
        List<Role> roleByUserId = roleDao.findRoleByUserId("111-222");
        for (Role role : roleByUserId) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                System.out.println(permission);
            }
        }
    }
}
