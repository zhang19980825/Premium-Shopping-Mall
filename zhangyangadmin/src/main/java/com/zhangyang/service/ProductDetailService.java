package com.zhangyang.service;
import com.zhangyang.model.ProductDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
@FeignClient(value = "zhangyangproduct")
public interface ProductDetailService {

    @RequestMapping(value = "/insertProductoutDetail",method = RequestMethod.POST)
    public void insertProduct(@RequestBody ProductDetail productDetail);

}
