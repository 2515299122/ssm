package wubing.ssm_pro.service;

import wubing.ssm_pro.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(Integer page,Integer pageSizey)throws Exception;
    public void save(Product product)throws Exception;

    Product findById(String id);

    void update(Product product);

    void changeStatus(List<String> list, Integer productStatus);
}
