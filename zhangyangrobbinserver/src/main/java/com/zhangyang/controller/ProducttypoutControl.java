package com.zhangyang.controller;

import com.zhangyang.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProducttypoutControl {
    /**
     * 注入RestTemplate
     */
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/listproductouttype",method = RequestMethod.GET)
    public List<ProductType> listproducttype(){
        String url="http://zhangyangproducttype/listproductouttype";
        List<ProductType> list = restTemplate.getForObject(url,List.class);
        return list;
    }

}
