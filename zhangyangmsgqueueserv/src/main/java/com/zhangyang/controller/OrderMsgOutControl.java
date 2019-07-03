package com.zhangyang.controller;

import com.zhangyang.msg.OrderSender;
import com.zhangyang.vo.OrderAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderMsgOutControl {
    @Autowired
    private OrderSender orderSender;

    @RequestMapping(value = "/sendordermsg",method = RequestMethod.GET)
    public void sendordermsg(@RequestParam String msg) {
        orderSender.send(msg);
    }

    @RequestMapping(value = "/sendordermsgbyobj",method = RequestMethod.POST)
    public void sendordermsgbyobj(@RequestBody OrderAll orderAll) {
        orderSender.send(orderAll);
    }
}
