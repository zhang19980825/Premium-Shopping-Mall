package com.zhangyang.controller;

import com.zhangyang.model.ProductType;
import com.zhangyang.service.ProducttypeService;
import com.zhangyang.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/22 18:11
 */
@Controller
public class ProducttypeoutController {
    @Autowired
    ProducttypeService producttypeService;

    @RequestMapping(value = "/listproductouttype",method = RequestMethod.GET)
    @ResponseBody
    public List<ProductType> listproductouttype(){
        List<ProductType> list = producttypeService.listallproduct();
        return list;
    }

    @RequestMapping(value="/insertoutProducttype",method = RequestMethod.POST)
    public void insertoutProducttype(@RequestBody ProductType productType){
        producttypeService.insertProducttype(productType);
    }

    @RequestMapping(value="/findoutProducttypeByid",method = RequestMethod.GET)
    @ResponseBody
    public ProductType findProducttypeByid(@RequestParam int id){
        ProductType productType=producttypeService.findProducttypeByid(id);
        if(productType==null){
            productType=new  ProductType();
            productType.setId(-1);
        }
        return productType;
    }

    @RequestMapping(value="/updateoutProductytpeByid",method = RequestMethod.POST)
    public void updateoutProductytpeByid(@RequestBody ProductType productype){
        producttypeService.updateProducttype(productype);
    }

    @RequestMapping(value="/delproductTypebyid",method = RequestMethod.GET)
    public void delProducttypeByid(@RequestParam  int id){
        producttypeService.delProducttypeByid(id);
    }

}
