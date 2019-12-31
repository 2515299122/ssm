import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wubing.ssm_pro.dao.ProductDao;
import wubing.ssm_pro.domain.Product;
import wubing.ssm_pro.service.ProductService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProduct {
    @Autowired
    private ProductDao dao;
    @Autowired
    private ProductService service;

    @Test
    public void testConnection() throws Exception {
        List<Product> list = dao.findAll();
        System.out.println("查询所有产品....");
        for (Product product : list) {
            System.out.println(product);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("/////////////////////////////////////");
        }

        List<Product> all = service.findAll(1, 4);
        for (Product product : all) {
            System.out.println(product);
        }
    }
}
