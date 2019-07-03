package com.zhangyang.service;

import com.zhangyang.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "zhangyangmsgqueueserv")
public interface OrderMsgOutService {

    @RequestMapping(value = "/sendordermsgby",method = RequestMethod.GET)
    public void sendordermsgby(@RequestParam(value ="msg") String msg);

    @RequestMapping(value = "/sendordermsgbyobj",method = RequestMethod.POST)
    public void sendordermsgbyobj(@RequestBody OrderAll orderAll);
}
