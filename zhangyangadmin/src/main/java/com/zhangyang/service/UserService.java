package com.zhangyang.service;

import com.zhangyang.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/27 16:37
 */
@FeignClient(value = "zhangyangshopuser")
public interface UserService {
    @RequestMapping(value = "/listoutUser",method = RequestMethod.GET)
    public List<User> listoutUser();

}
