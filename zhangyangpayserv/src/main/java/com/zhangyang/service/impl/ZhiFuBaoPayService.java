package com.zhangyang.service.impl;

import com.zhangyang.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/26 13:13
 */
@Service
public class ZhiFuBaoPayService implements PayService {
    @Override
    public int payWithpayAmount(String tradenumber, int amount) {
        System.out.println("支付宝支付成功");
        return 0;
    }
}
