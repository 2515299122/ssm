package wubing.ssm_pro.service;

import wubing.ssm_pro.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(Integer page,Integer pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;

    void save(Orders orders);
}
