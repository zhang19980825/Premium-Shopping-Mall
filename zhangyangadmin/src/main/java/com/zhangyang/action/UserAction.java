package com.zhangyang.action;

import com.zhangyang.model.User;
import com.zhangyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/27 16:42
 */
@Controller
public class UserAction {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listuser",method = RequestMethod.GET)
    public String listuser(Model model) {
        List<User> listuser = userService.listoutUser();
        model.addAttribute("userlist", listuser);
        return "listuser";
    }
}
