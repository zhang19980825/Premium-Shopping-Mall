package com.zhangyang.service;

import com.zhangyang.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zhangyangmsgqueueserv")
public interface OrderMsgOutService {

    @RequestMapping(value = "/sendordermsg",method = RequestMethod.GET)
    public void sendordermsg(@RequestParam(value = "msg") String msg);

    @RequestMapping(value = "/sendordermsgbyobj",method = RequestMethod.POST)
    public void sendordermsgbyobj(@RequestBody OrderAll orderAll);
}
