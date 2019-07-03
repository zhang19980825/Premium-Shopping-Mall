package com.zhangyang.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/27 16:18
 */
@Controller
public class indexAction {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }
}

