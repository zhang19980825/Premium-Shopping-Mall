package com.zhangyang.controller;

import com.zhangyang.model.Product;
import com.zhangyang.model.ProductType;
import com.zhangyang.service.ProductService;
import com.zhangyang.service.ProductTypeService;
import com.zhangyang.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/listproductouttype",method = RequestMethod.GET)
    public String listproductouttype(Model model){
        List<ProductType> list=productTypeService.listproducttype();
        model.addAttribute("productypelist",list);
        System.out.println(list);
        return "list";
    }

}
