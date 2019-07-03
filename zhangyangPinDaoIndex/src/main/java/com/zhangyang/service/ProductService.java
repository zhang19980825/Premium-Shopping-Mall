package com.zhangyang.service;

import com.zhangyang.model.Product;
import com.zhangyang.model.ProductDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@FeignClient(value = "zhangyangproduct")
public interface ProductService {
    @RequestMapping(value = "/listview",method = RequestMethod.GET)
    List<Product> listproduct(@RequestParam(value = "producttypeid") int producttypeid);

    @RequestMapping(value = "/searchproductout",method = RequestMethod.GET)
    public List<Product> searchproductout(@RequestParam(value = "keyword") String keyword);

    @RequestMapping(value = "/findproductdetailbyid",method = RequestMethod.POST)
    public ProductDetail findproductdetailbyid(@RequestParam(value = "productid") int productid);

    @RequestMapping(value="/viewoutProduct",method = RequestMethod.GET)
    public Product viewoutProduct(@RequestParam(value = "id")int id);
}
