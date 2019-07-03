package com.zhangyang.controller;


import com.zhangyang.utils.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MsgsendControl {

    @Autowired
    private HelloSender helloSender;

    /**
     * 单生产者-单个消费者
     */
    @RequestMapping("/test")
    public void hello() throws Exception {
        System.out.println("Hello World");
        helloSender.send();
    }
}
