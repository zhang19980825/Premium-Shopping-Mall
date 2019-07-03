package com.zhangyang.controller;

import com.zhangyang.model.Product;
import com.zhangyang.service.ProductService;
import com.zhangyang.vo.ConstomProduct;
import com.zhangyang.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/26 18:17
 */
@Controller
public class ProductoutController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/listview",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> listview(@RequestParam int producttypeid){
        ConstomProduct constomProduct=new ConstomProduct();
        constomProduct.setProducttypeid(producttypeid);
        ProductVo productVo=new ProductVo();
        productVo.setConstomProduct(constomProduct);
        List<Product> list = productService.queryProductbyvo(productVo);
        return list;
    }

    @RequestMapping(value="/insertoutProduct",method = RequestMethod.POST)
    public void insertoutProduct(@RequestBody Product product){
        product.setCreattime(new Date());
        product.setSellnum(0);
        product.setProductstatus(0);
        productService.insertProduct(product);
    }

    @RequestMapping(value="/viewoutProduct",method = RequestMethod.GET)
    @ResponseBody
    public Product viewoutProduct(int id){
        Product product=productService.findproductbyid(id);
        return product;
    }

    @RequestMapping(value="/deleteoutProduct",method = RequestMethod.GET)
    public void deleteProduct(int id){
        productService.deleteProductbyid(id);
    }

    @RequestMapping(value="/updateoutProduct",method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product){
        productService.upateProduct(product);
    }


    @RequestMapping(value = "/searchproductout",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> searchproductout(@RequestParam String keyword){
        List<Product> list=productService.queryProductbyids(keyword);
        return list;
    }

    @RequestMapping(value = "/upateProductbyquartz",method = RequestMethod.GET)
    @ResponseBody
    public void upateProductbyquartz(@RequestBody Product product){
        productService.upateProductbyquartz(product);
    }
}
