package com.zhangyang.hystrix;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangyang.model.ProductType;
import com.zhangyang.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@Service
public class ProductTypeServicehystrix {
    @Autowired
    ProductTypeService productTypeService;

    @HystrixCommand(fallbackMethod = "listproductTypeFallback")
    public List<ProductType> listproductType(){
        return productTypeService.listproducttype();
    }

    public List<ProductType> listproductTypeFallback(){
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setParentid(-1);
        productType.setProducttypedescription("吃的");
        productType.setProducttypename("食品18");
        productType.setTypegrade(1);
        List<ProductType> list = new ArrayList<ProductType>();
        list.add(productType);
        return list;

    }

}
