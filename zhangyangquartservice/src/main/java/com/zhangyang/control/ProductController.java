package com.zhangyang.control;

import com.zhangyang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController("productcontrollerquart")
@RequestMapping(value = "/productinfoupdate")
public class ProductController {
    /**
     * 商品业务逻辑实现
     */
    @Autowired
    private ProductService productService;

    /**
     */
    @RequestMapping(value = "/updateproductbyid")
    public void updateproductbyid() {
        productService.updateproductbyid();
    }
}
