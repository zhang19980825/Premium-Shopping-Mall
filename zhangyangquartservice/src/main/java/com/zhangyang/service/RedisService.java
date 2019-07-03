package com.zhangyang.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(value = "zhangyangredis")
public interface RedisService {

    @RequestMapping(value = "/setkey",method = RequestMethod.GET)
    public void setkey(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) ;

    @RequestMapping(value = "/getallproductkeys",method = RequestMethod.POST)
    public Set<String> getallproductkeys();
}
