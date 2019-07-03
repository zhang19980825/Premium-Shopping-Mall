package com.zhangyang.dao;

import com.zhangyang.mapper.OrderDetailMapper;
import com.zhangyang.mapper.OrderMapper;
import com.zhangyang.model.Order;
import com.zhangyang.model.OrderDetail;
import com.zhangyang.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:06
 */
@Component
public class OrderDetailDao {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    public void  insertOrderDetail(OrderDetail orderDetail){
        orderDetailMapper.insertOrderDetail(orderDetail);
    }

}
