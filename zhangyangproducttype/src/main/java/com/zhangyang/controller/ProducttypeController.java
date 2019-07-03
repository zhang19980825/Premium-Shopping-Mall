package com.zhangyang.controller;

import com.zhangyang.model.ProductType;
import com.zhangyang.service.ProducttypeService;
import com.zhangyang.vo.ProductTypeVo;
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
 * @Date: 2019/5/22 18:11
 */
@Controller
public class ProducttypeController {
    @Autowired
    ProducttypeService producttypeService;

    @RequestMapping(value="/insertProducttype",method = RequestMethod.POST)
    public void insertProducttype(ProductType productType){
        producttypeService.insertProducttype(productType);
    }

    @RequestMapping(value="/findProducttypeByid",method = RequestMethod.GET)
    public String findProducttypeByid(int id, Model model){
        ProductType productType=producttypeService.findProducttypeByid(id);
        int parentid=productType.getParentid();
        ProductType parentproductType=producttypeService.findProducttypeByid(parentid);
        if(parentproductType==null){
            parentproductType=new  ProductType();
            parentproductType.setProducttypename("");
        }
        model.addAttribute("productType",productType);
        model.addAttribute("parentproductType",parentproductType);
        return "producttypeview";
    }
    @RequestMapping(value="/toupdateProducttype",method = RequestMethod.GET)
    public String toupdateProducttype(int id, Model model){
        ProductType productType=producttypeService.findProducttypeByid(id);
        model.addAttribute("productType",productType);
        return "producttypeupdate";
    }

    @RequestMapping(value="/updateProducttype",method = RequestMethod.POST)
    public void updateProducttype(ProductType productype, Model model){
        producttypeService.updateProducttype(productype);
    }

    @RequestMapping(value="/toaddProducttypeByid",method = RequestMethod.GET)
    public String toaddProducttypeByid(int id, Model model){
        ProductType productType=producttypeService.findProducttypeByid(id);
        if(productType==null){
            productType=new ProductType();
            productType.setId(-1);
        }
        model.addAttribute("productType",productType);
        return "producttypeadd";
    }

    @RequestMapping(value="/listproducttype",method = RequestMethod.GET)
    public String listproducttype(Model model){
            ProductTypeVo productTypeVo=new ProductTypeVo();
            List<ProductType>list= producttypeService.queryListbyvo(productTypeVo);
            model.addAttribute("list",list);
            return "list";
    }

    @RequestMapping(value="/delProducttypeByid",method = RequestMethod.GET)
    public void delProducttypeByid(int id){
        producttypeService.delProducttypeByid(id);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String viewProduct(@RequestParam String name){
        return "hi "+name+",i am from port:";
    }
}
