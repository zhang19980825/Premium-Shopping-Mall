package com.zhangyang.service;
import com.zhangyang.model.ProductType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
@FeignClient(value = "zhangyangproducttype")
public interface ProductTypeService {
    @RequestMapping(value = "/listproductouttype",method = RequestMethod.GET)
    public List<ProductType> listproductType();

    @RequestMapping(value = "/insertoutProducttype",method = RequestMethod.POST)
    public void insertProducttype(@RequestBody ProductType productType);

    @RequestMapping(value = "/findoutProducttypeByid",method = RequestMethod.GET)
    public ProductType findProductytpeByid(@RequestParam(value = "id") int id);


    @RequestMapping(value = "/updateoutProductytpeByid",method = RequestMethod.POST)
    public void updateProductytpeByid(@RequestBody ProductType productType);


}
