package com.zhangyang.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/26 16:47
 */
@FeignClient(value = "zhangyangproducttype")
public interface SchedualServiceHi {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
