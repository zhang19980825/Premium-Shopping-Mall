package com.zhangyang.service;

import com.zhangyang.WechatConfig;
import com.zhangyang.mapper.UserMapper;
import com.zhangyang.model.User;
import com.zhangyang.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: ZhangYang
 * @Date: 2019/6/1 12:58
 */
@Service
public class UserLoginService {
    @Autowired
    private WechatConfig weChatConfig;

    @Autowired
    private UserMapper userMapper;

    public User saveWeChatUser(String code) {
        String accessTokenUrl = String.format(WechatConfig.getOpenAccessTokenUrl(),weChatConfig.getOpenAppId(),weChatConfig.getOpenSecret(),code);

        //获取access_token
        Map<String ,Object> baseMap =  HttpUtils.doGet(accessTokenUrl);

        if(baseMap == null || baseMap.isEmpty()){ return  null; }
        System.out.println(baseMap.get("access_token"));
        String accessToken = (String)baseMap.get("access_token");
        int openId  = (int)baseMap.get("openid");

        User dbUser=userMapper.findByUserid(openId);
        if(dbUser!=null) { //更新用户，直接返回
            return dbUser;
        }
        //获取用户基本信息
        String userInfoUrl = String.format(WechatConfig.getOpenUserInfoUrl(),accessToken,openId);
        //获取access_token
        Map<String ,Object> baseUserMap =  HttpUtils.doGet(userInfoUrl);

        if(baseUserMap == null || baseUserMap.isEmpty()){ return  null; }
        String nickname = (String)baseUserMap.get("nickname");

        Double sexTemp  = (Double) baseUserMap.get("sex");
        int sex = sexTemp.intValue();
        String province = (String)baseUserMap.get("province");
        String city = (String)baseUserMap.get("city");
        String country = (String)baseUserMap.get("country");
        String headimgurl = (String)baseUserMap.get("headimgurl");
        StringBuilder sb = new StringBuilder(country).append("||").append(province).append("||").append(city);
        String finalAddress = sb.toString();
        try {
            //解决乱码
            nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");
            finalAddress = new String(finalAddress.getBytes("ISO-8859-1"), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //根据数据库的字段而定
        User user = new User();
        user.setName(nickname);
      /*  user.set
        user.setHeadImg(headimgurl);
        user.setCity(finalAddress);
        user.setOpenid(openId);
        user.setSex(sex);
        user.setCreateTime(new Date());*/
        userMapper.updateUser(user);
        return user;
    }

}
