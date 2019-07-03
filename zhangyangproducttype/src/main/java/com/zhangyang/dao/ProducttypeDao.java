package com.zhangyang.dao;

import com.zhangyang.mapper.ProducttypeMapper;
import com.zhangyang.model.ProductType;
import com.zhangyang.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/22 18:08
 */
@Component
public class ProducttypeDao {
    @Autowired
    ProducttypeMapper producttypeMapper;
    public void insertProducttype(ProductType productType){
        producttypeMapper.insertProducttype(productType);
    }

    public ProductType findProducttypeByid(int id){
        return producttypeMapper.findProducttypeByid(id);
    }
    public void updateProducttype( ProductType producttype){
        producttypeMapper.updateProducttype(producttype);
    }
    public List<ProductType> queryListbyvo(ProductTypeVo productTypeVo){
        return producttypeMapper.queryListbyvo(productTypeVo);
    }
    public void delProducttypeByid(int id){
        producttypeMapper.delProducttypeByid(id);
    }
    public List<ProductType> listallproduct(){
        return producttypeMapper.listallproduct();
    }
}
