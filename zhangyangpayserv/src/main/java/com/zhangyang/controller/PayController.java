package com.zhangyang.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangyang.model.Order;
import com.zhangyang.service.OrderService;
import com.zhangyang.service.impl.WechatPayService;
import com.zhangyang.service.impl.YinLianPayService;
import com.zhangyang.service.impl.ZhiFuBaoPayService;
import com.zhangyang.service.weixin.PayRequest;
import com.zhangyang.service.weixin.PayResponse;
import com.zhangyang.service.weixin.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/26 13:16
 */
@Controller
@Slf4j
public class PayController {
    @Autowired
    WechatPayService wechatPayService;
    @Autowired
    ZhiFuBaoPayService zhiFuBaoPayService;
    @Autowired
    YinLianPayService yinLianPayService;
    @Autowired
    OrderService orderService;

    /**
     * create by: 张阳
     * description: TODO
     * create time: 2019/5/26 13:39
     * @Param: paytype  1 微信支付  2银联支付 3支付宝支付
     * @Param: tradenumber
     * @Param: amount
     * @return int  1 支付成功  2支付失败
     */
    @RequestMapping(value ="payWithAmout" )
    public int payWithAmout(String paytype,String tradenumber,int amount){
        int payresult=2;
        if("1".equals(paytype)){
            payresult=wechatPayService.payWithpayAmount(tradenumber,amount);
        }else if("2".equals(paytype)){
            payresult=yinLianPayService.payWithpayAmount(tradenumber,amount);
        }else if("3".equals(paytype)){
            payresult=zhiFuBaoPayService.payWithpayAmount(tradenumber,amount);
        }
        return payresult;
    }

    @GetMapping("/auth")
    public ModelAndView auth(@RequestParam("code") String code,@RequestParam("orderid") int orderid  ) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxgq6ue658o0nbn139&redirect_uri=http://api.xdclass.net/auth?orderid=2&response_type=code&scope=snsapi_base#wechat_redirect
        //https://open.weixin.qq.com/connect/qrconnect?appid=wxgq6ue658o0nbn139&redirect_uri=http://api.xdclass.net/auth&response_type=code&scope=snsapi_login&state=%s#wechat_redirect
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxgq6ue658o0nbn139&secret=dx3p6l4vq4ds1694oxwlbsiv2oo78ndd&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        JSONObject object = JSONObject.parseObject(response);
        String openid = object.getString("openid");

        WxPayServiceImpl wxPayService=new WxPayServiceImpl();
        PayRequest request=new PayRequest();
        request.setOrderName("支付测试");  //订单名称
        //订单查询
        request.setOrderId(orderid+"");  //订单号
        Order order=orderService.findOrderByid(orderid);
        request.setOrderAmount(order.getPayamount());  //从订单中查询  支付金额
        request.setOpenid(openid);  //微信的openID
        PayResponse payResponse=wxPayService.pay(request);
        log.info("====="+openid);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("payResponse", payResponse);
        map.put("returnUrl", "http://api.xdclass.net/auth/notify");
        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        WxPayServiceImpl wxPayServiceImpl = new WxPayServiceImpl();
        PayResponse payResponse = wxPayServiceImpl.asyncNotify(notifyData);
        if(payResponse != null && payResponse.getOrderId() != null){
            String orderid = payResponse.getOrderId();
            orderService.updateorderstatebyid(Integer.valueOf(orderid),1,2);
        }
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }


}
