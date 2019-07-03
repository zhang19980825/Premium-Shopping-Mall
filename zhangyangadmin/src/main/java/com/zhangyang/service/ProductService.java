package com.zhangyang.service;
import com.zhangyang.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "zhangyangproduct")
public interface ProductService {
    @RequestMapping(value = "/listview",method = RequestMethod.GET)
    List<Product> listproduct(@RequestParam(value = "producttypeid") int producttyeid);

    @RequestMapping(value = "/insertoutProduct",method = RequestMethod.POST)
    public void insertProduct(@RequestBody Product product);

    @RequestMapping(value = "/viewoutProduct",method = RequestMethod.GET)
    public Product viewProduct(@RequestParam(value = "id") int id);

    @RequestMapping(value = "/deleteoutProduct",method = RequestMethod.GET)
    public void deleteProduct(@RequestParam(value = "id") int id);

    @RequestMapping(value = "/updateoutProduct",method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product);

}
