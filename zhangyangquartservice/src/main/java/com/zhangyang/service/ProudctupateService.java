package com.zhangyang.service;

import com.zhangyang.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "zhangyangproduct")
public interface ProudctupateService {

    @RequestMapping(value = "/upateProductbyquartz",method = RequestMethod.POST)
    public void upateProductbyquartz(@RequestBody Product product);
}
