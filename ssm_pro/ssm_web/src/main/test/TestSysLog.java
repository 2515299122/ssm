import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wubing.ssm_pro.dao.SysLogDao;
import wubing.ssm_pro.domain.SysLog;
import wubing.ssm_pro.service.SysLogService;

import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSysLog {
    @Autowired
    private SysLogDao sysLogDao;

    @Autowired
    private SysLogService sysLogService;
    @Test
    public void test_findAll() throws Exception {
        List<SysLog> all = sysLogDao.findAll();
        for (SysLog sysLog : all) {
            System.out.println(sysLog);
        }
    }
    @Test
    public void test_save() throws Exception {
        SysLog sysLog = new SysLog();
        sysLog.setUrl("/findall");
        sysLog.setIp("2");
        sysLog.setExecutionTime(1L);
        sysLog.setUsername("123");
        sysLog.setVisitTime(new Date());
        sysLogService.save(sysLog);
    }
}
