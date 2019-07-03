package com.zhangyang.controller;

import com.zhangyang.model.Product;
import com.zhangyang.service.ProductService;
import com.zhangyang.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:18
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/listproduct",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> sayHi(@RequestParam int producttypeid){
        List<Product> list=productService.listproduct(producttypeid);
        System.out.println(list);
        return list;
    }

    @Autowired
    SchedualServiceHi schedualServiceHi;

    /*@RequestMapping(value="/listProduct",method = RequestMethod.GET)
    public String listProduct(Model model){
        ProductVo productVo=new ProductVo();
        List<Product> list = productService.queryProductbyvo(productVo);
        model.addAttribute("list",list);
        return "listProduct";
    }*/


    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
    public String sayHi(@RequestParam String name){
        String test=schedualServiceHi.sayHiFromClientOne(name);
        return test;
    }





}
