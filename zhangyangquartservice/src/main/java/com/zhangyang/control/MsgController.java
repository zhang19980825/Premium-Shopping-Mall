package com.zhangyang.control;

import com.zhangyang.service.MsgService;
import com.zhangyang.model.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 */
@Controller
@RequestMapping(value = "/msgController")
public class MsgController {

    @Autowired
    private MsgService msgService;

    /**
     */
    @RequestMapping(value = "/listall")
    public String listall(Model model) {
        List<MessageLog> msglist = msgService.listbyall();
        model.addAttribute("messagelist",msglist);
        return "listallmsg";
    }

}
