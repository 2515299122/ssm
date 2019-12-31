package wubing.ssm_pro.dao;


import org.apache.ibatis.annotations.Select;
import wubing.ssm_pro.domain.Traveller;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
