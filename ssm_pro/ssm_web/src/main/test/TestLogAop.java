import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLogAop {
    @Autowired
    private Test1 test1;
    @Test
    public void test1(){
        test1.show();
    }
}
