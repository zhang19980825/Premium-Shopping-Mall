package com.zhangyang.service;

import com.zhangyang.dao.OrderDao;
import com.zhangyang.dao.OrderDetailDao;
import com.zhangyang.model.Order;
import com.zhangyang.model.OrderDetail;
import com.zhangyang.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:07
 */
@Service
public class OrderDetailService {
    @Autowired
    OrderDetailDao orderDetailDao;

    public void  insertOrderDetail(OrderDetail orderDetail){
        orderDetailDao.insertOrderDetail(orderDetail);
    }
}
