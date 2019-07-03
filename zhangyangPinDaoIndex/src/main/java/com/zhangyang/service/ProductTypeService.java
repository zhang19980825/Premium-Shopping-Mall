package com.zhangyang.service;

import com.zhangyang.model.Product;
import com.zhangyang.model.ProductType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@FeignClient(value = "zhangyangrobbinserver")
public interface ProductTypeService {
    @RequestMapping(value = "/listproductouttype",method = RequestMethod.GET)
    List<ProductType> listproducttype() ;

}
