package com.zhangyang.redis.control;

import com.zhangyang.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RedisControl {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/getkey",method = RequestMethod.GET)
    public String getkey(String key) {
        String reuslt = redisService.getStr(key);
        return reuslt;
    }

    @RequestMapping(value = "/setkey",method = RequestMethod.GET)
    public void setkey(String key,String value) {
        redisService.setStr(key,value);
    }

    @RequestMapping(value = "/getallproductkeys",method = RequestMethod.POST)
    public Set<String> getallproductkeys() {
        Set<String> set = redisService.getAllkeys();
        return set;
    }
}
