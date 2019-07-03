package com.zhangyang.dao;

import com.zhangyang.mapper.ProductMapper;
import com.zhangyang.model.Product;
import com.zhangyang.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:16
 */
@Component
@CacheConfig(cacheNames = "productchache")
public class ProductDao {

    @Autowired
    ProductMapper productMapper;

    @Cacheable
    public int insertProduct(Product product){
        return productMapper.insertProduct(product);
    }
    public void auditProduct(Product product){
        productMapper.auditProduct( product);
    }

    @Cacheable(value = "productchache",key = "#id")
    public Product findproductbyid(int id){
        System.out.println("进入查询");
        return productMapper.findproductbyid(id);
    }

    @Cacheable(value = "productchache",key = "#product.id")
    public Product upateProduct(Product product){
        productMapper.upateProduct(product);
        return product;
    }
    public void deleteProductbyid(int id){
        productMapper.deleteProductbyid(id);
    }
    public List<Product> queryProductbyvo(ProductVo productVo){
        return  productMapper.queryProductbyvo(productVo);
    }
    public void updateProductbyproductstatus(Product product){
        productMapper.updateProductbyproductstatus(product);
    }
    public List<Product> queryProductbyids(List<String>ids){
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        map.put("ids",ids);
        return productMapper.queryProductbyids(map);
    }

    @Cacheable(value = "productchache",key = "#product.id")
    public Product upateProductbyquartz(Product product){
        return product;
    }
}
