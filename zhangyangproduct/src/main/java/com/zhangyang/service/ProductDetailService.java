package com.zhangyang.service;

import com.zhangyang.dao.ProductDetailDao;
import com.zhangyang.model.ProductDetail;
import com.zhangyang.utils.SolrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/28 17:28
 */
@Service
public class ProductDetailService {
    @Autowired
    ProductDetailDao productDetailDao;


    public void insertProductDetail(ProductDetail productDetail){
        try {
            int id=productDetailDao.insertProductDetail(productDetail);
            Map<String,Object> mapVlue = new HashMap<String,Object>();
            mapVlue.put("id",productDetail.getProductid());
            System.out.println(productDetail.getProductid());
            mapVlue.put("productdescription",productDetail.getProductdescription());
            System.out.println(productDetail.getProductdescription());
            SolrUtil.addIndex2(mapVlue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductDetail findproductdetailbyid(int productid){
        return productDetailDao.findproductdetailbyid(productid);
    }

}
