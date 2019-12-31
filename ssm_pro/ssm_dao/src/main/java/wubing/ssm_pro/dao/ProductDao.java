package wubing.ssm_pro.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import wubing.ssm_pro.domain.Product;

import java.util.List;
public interface ProductDao {
    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll()throws Exception;
    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);
    @Select("select * from product where id=#{id}")
    public Product findById(String id);
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void update(Product product);
    @Update("update product set productStatus=#{productStatus} where id=#{id}")
    void changeStatus(@Param("id") String s, Integer productStatus);
}
