package com.zhangyang.control;

import com.zhangyang.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping(value = "/msgrestController")
public class MsgRestController {

    @Autowired
    private MsgService msgService;


    @RequestMapping(value = "/starttask")
    public void starttask() {
        msgService.processmsgbystatus();
    }
}
