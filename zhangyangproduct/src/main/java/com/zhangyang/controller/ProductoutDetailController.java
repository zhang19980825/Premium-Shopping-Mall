package com.zhangyang.controller;

import com.zhangyang.dao.ProductDetailDao;
import com.zhangyang.model.ProductDetail;
import com.zhangyang.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/28 17:29
 */
@RestController
public class ProductoutDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(value = "/insertProductoutDetail",method = RequestMethod.POST)
    public void insertProductDetail( @RequestBody ProductDetail productDetail){
        productDetailService.insertProductDetail(productDetail);
    }

    @RequestMapping(value = "/findproductdetailbyid",method = RequestMethod.POST)
    public ProductDetail findproductdetailbyid(@RequestParam int productid){
        return productDetailService.findproductdetailbyid(productid);
    }
}
