package com.zhangyang.dao;

import com.zhangyang.mapper.ProductDetailMapper;
import com.zhangyang.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/28 17:26
 */
@Component
public class ProductDetailDao {

    @Autowired
    ProductDetailMapper productDetailMapper;

    public int insertProductDetail(ProductDetail productDetail){
        return productDetailMapper.insertProductDetail(productDetail);
    }

    public ProductDetail findproductdetailbyid(int productid){
        return productDetailMapper.findproductdetailbyid(productid);
    }

}
