package com.zhangyang.controller;

import com.zhangyang.model.User;
import com.zhangyang.service.UserService;
import com.zhangyang.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/21 21:01
 */
@Api("用户服务对外模块")
@Controller
public class UserOutController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户数据", notes = "无需传入参数")
    @RequestMapping(value = "/listoutUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> listoutUser() {        UserVo userVo = new UserVo();
        List<User> listuser = userService.queryuserbyvo(userVo);
        return listuser;
    }

    @RequestMapping(value = "/useroutregister", method = RequestMethod.POST)
    public void useroutregister(@RequestBody  User user) {
        userService.insertuserInfo(user);
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.POST)
    @ResponseBody
    public User findByUsername(@RequestParam String name,Model model) {
        User user = userService.findByUsername(name);
        model.addAttribute("user", user);
        return user;
    }

}
