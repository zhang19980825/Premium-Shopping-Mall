package com.zhangyang.controller;

import com.zhangyang.model.User;
import com.zhangyang.service.UserService;
import com.zhangyang.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/21 21:01
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.findUserInfo();
        if (user != null) {
            System.out.println("user.getName()" + user.getName());
        }
        return user;
    }

    @RequestMapping(value = "/tourserregister", method = RequestMethod.GET)
    public String tourserregister() {
        return "userregister";
    }

    @RequestMapping(value = "/userregister", method = RequestMethod.POST)
    public void userregister(User user) {
        userService.insertuserInfo(user);
        return;
    }

    @RequestMapping(value = "/toupdateUser", method = RequestMethod.GET)
    public String toupdateUser(int id, Model model) {
        User user = userService.findByUserid(id);
        model.addAttribute("user", user);
        return "userupdate";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/findByUserid", method = RequestMethod.GET)
    public String findByUserid(int id, Model model) {
        User user = userService.findByUserid(id);
        model.addAttribute("user", user);
        return "userview";
    }

    @RequestMapping(value = "/queryuserbyvo", method = RequestMethod.GET)
    public String queryuserbyvo(UserVo userVo, Model model) {
        UserVo userVo1 = new UserVo();
        List<User> listuser = userService.queryuserbyvo(userVo);
        model.addAttribute("listuser", listuser);
        return "userlist";
    }

    @RequestMapping(value = "/deleteuserbyid", method = RequestMethod.GET)
    public void deleteuserbyid(int id) {
        userService.deleteuserbyid(id);
    }
}
