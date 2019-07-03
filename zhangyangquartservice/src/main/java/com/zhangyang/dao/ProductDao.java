package com.zhangyang.dao;

import com.zhangyang.mapper.ProductMapper;
import com.zhangyang.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductDao {
    @Autowired
    ProductMapper productMapper;

    public List<Product> findproductbyids(List<String> ids){
        return productMapper.findproductbyids(ids);

    }

}
