package com.zhangyang.controller;

import com.zhangyang.WechatConfig;
import com.zhangyang.model.User;
import com.zhangyang.service.UserLoginService;
import com.zhangyang.service.UserService;
import com.zhangyang.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/27 16:42
 */
@Controller
public class UserAction {
    @Autowired
    private WechatConfig wechatConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/listuser",method = RequestMethod.GET)
    public String listuser(Model model) {
        List<User> listuser = userService.listoutUser();
        model.addAttribute("userlist", listuser);
        return "listuser";
    }


    @RequestMapping(value = "/touserregister", method = RequestMethod.GET)
    public String tourserregister(User user) {
        return "userregister";
    }

    @RequestMapping(value = "/userregister",method = RequestMethod.POST)
    public void userregister(User user){
        userService.userregister(user);
    }

    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
    public String tologin(User user) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String account, String password, HttpServletRequest request) {
        User user=userService.findByUsername(account);
        if(user==null){
            System.out.println("无此用户");
        }else{
            if(user.getPasswordencrypt().equals(password)){
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
            }else{
                System.out.println("密码错误");
            }
        }
        return "list";
    }


    /*
    * 微信登录地址
    * */
    @GetMapping("login_url")
    @ResponseBody
    public String loginUrl(@RequestParam(value = "access_page",required = true)String accessPage)throws UnsupportedEncodingException {
        String redirectUrl=wechatConfig.getOpenRedirectUrl();

        String callbackUrl=URLEncoder.encode(redirectUrl,"GBK");

        String qrcodeUrl = String.format(wechatConfig.getOpenQrcodeUrl(),wechatConfig.getOpenAppId(),callbackUrl,accessPage);

        return qrcodeUrl;
    }

    /**
     * 微信扫码登录回调地址
     * @param code
     * @param state
     * @param response
     */
    @GetMapping("/user/callback")
    public void wechatUserCallback(@RequestParam(value = "code",required = true) String code,
                                   String state, HttpServletResponse response)throws IOException {


        User user = userLoginService.saveWeChatUser(code);
        if(user!= null){
            //生成jwt
            String token=JwtUtils.geneJsonWebToken(user);
            // state 当前用户的页面地址，需要拼接 http://  这样才不会站内跳转
            response.sendRedirect(state+"?token="+token+"&name="+URLEncoder.encode(user.getName(),"UTF-8"));
        }


    }

}
