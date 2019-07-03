package com.zhangyang.controller;

import com.zhangyang.model.Product;
import com.zhangyang.service.ProductService;
import com.zhangyang.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:18
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/insertProduct",method = RequestMethod.POST)
    public void insertProduct(Product product){
        product.setCreattime(new Date());
        product.setSellnum(0);
        product.setProductstatus(0);
        productService.insertProduct(product);
    }

    @RequestMapping(value="/toinsertProduct",method = RequestMethod.GET)
    public String toinsertProduct(Product product){
        return "addproduct";
    }


    @RequestMapping(value="/toAuditProduct",method = RequestMethod.GET)
    public String toAuditProduct(int id, Model model){
        Product product=productService.findproductbyid(id);
        model.addAttribute("product",product);
        return "auditproduct";
    }

    @RequestMapping(value="/auditProduct",method = RequestMethod.POST)
    public void auditProduct(Product product){
       productService.auditProduct(product.getId(),product.getAuditstate());
    }

    @RequestMapping(value="/listProduct",method = RequestMethod.GET)
    public String listProduct(Model model){
        ProductVo productVo=new ProductVo();
        List<Product> list = productService.queryProductbyvo(productVo);
        model.addAttribute("list",list);
        return "listProduct";
    }

    @RequestMapping(value="/viewProduct",method = RequestMethod.GET)
    public String viewProduct(int id, Model model){
        Product product=productService.findproductbyid(id);
        model.addAttribute("product",product);
        return "viewProduct";
    }

    @RequestMapping(value="/deleteProduct",method = RequestMethod.GET)
    public String deleteProduct(int id){
        productService.deleteProductbyid(id);
        return "listProduct";
    }

    @RequestMapping(value="/toupdateProduct",method = RequestMethod.GET)
    public String toupdateProduct(int id, Model model){
        Product product=productService.findproductbyid(id);
        model.addAttribute("product",product);
        return "updateproduct";
    }

    @RequestMapping(value="/updateProduct",method = RequestMethod.POST)
    public void udateProduct(Product product){
        productService.upateProduct(product);
    }

    @RequestMapping(value="/updateProductbyproductstatus",method = RequestMethod.GET)
    public void updateProductbyproductstatus(int id,int productstatus){
        productService.updateProductbyproductstatus(id,productstatus);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String viewProduct(@RequestParam String name){
        return "hi "+name+",i am from port:";
    }


    @RequestMapping(value="/viewProductwithoutredis",method = RequestMethod.GET)
    public String viewProductwithoutredis(int id, Model model){
        Product product=productService.findproductbyidwithoutredis(id);
        model.addAttribute("product",product);
        return "viewProduct";
    }

}
