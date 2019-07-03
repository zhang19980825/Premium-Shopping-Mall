package com.zhangyang.service;

import com.zhangyang.dao.ProducttypeDao;
import com.zhangyang.model.ProductType;
import com.zhangyang.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/22 18:10
 */
@Service
public class ProducttypeService {
    @Autowired
    ProducttypeDao producttypeDao;

    public void insertProducttype(ProductType productType){
        producttypeDao.insertProducttype(productType);
    }

    public ProductType findProducttypeByid(int id){
        return producttypeDao.findProducttypeByid(id);
    }

    public void updateProducttype( ProductType producttype){
        producttypeDao.updateProducttype(producttype);
    }
    public List<ProductType> queryListbyvo(ProductTypeVo productTypeVo){
        return producttypeDao.queryListbyvo(productTypeVo);
    }
    public void delProducttypeByid(int id){
        producttypeDao.delProducttypeByid(id);
    }
    public List<ProductType> listallproduct(){
        return producttypeDao.listallproduct();
    }

}
