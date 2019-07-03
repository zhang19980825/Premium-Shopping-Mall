package com.zhangyang.dao;

import com.zhangyang.mapper.OrderMapper;
import com.zhangyang.model.Order;
import com.zhangyang.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:06
 */
@Component
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;
    public void  insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public List<Order> listOrder(OrderVo orderVo){
        return orderMapper.listOrder(orderVo);
    }

    public void updateOrderWithUser(Order order){
        orderMapper.updateOrderWithUser(order);
    }
    public Order findOrderByid(int id){
        return orderMapper.findOrderByid(id);
    }
    public void deleteorderbyid(int id){
        orderMapper.deleteorderbyid(id);
    }
    public void updateOrderByid(Order order){
        orderMapper.updateOrderByid(order);
    }
    public List<Order> listOrderbyuserid(int userid){
        return orderMapper.listOrderbyuserid(userid);
    }
    public Order findOrderByTradenumber(String tradenumber){
        return orderMapper.findOrderByTradenumber(tradenumber);
    }


}
