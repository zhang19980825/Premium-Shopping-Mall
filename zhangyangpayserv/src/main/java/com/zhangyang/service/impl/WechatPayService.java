package com.zhangyang.service.impl;

import com.zhangyang.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/26 13:09
 */
@Service
public class WechatPayService implements PayService {

    /*
    * 0 支付成功 1支付异常
    * */
    @Override
    public int payWithpayAmount(String tradenumber, int amount) {
        System.out.println("微信支付成功");
        return 0;
    }
}
