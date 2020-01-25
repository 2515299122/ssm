package wubing.ssm_pro.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wubing.ssm_pro.dao.OrdersDao;
import wubing.ssm_pro.domain.Orders;
import wubing.ssm_pro.service.OrdersService;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }

    @Override
    public void save(Orders orders) {
        ordersDao.save(orders);
    }


}
