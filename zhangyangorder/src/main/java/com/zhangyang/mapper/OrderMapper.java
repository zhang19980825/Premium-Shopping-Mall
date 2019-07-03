package com.zhangyang.mapper;

import com.zhangyang.model.Order;
import com.zhangyang.vo.OrderVo;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:04
 */
public interface OrderMapper {
    public void  insertOrder(Order order);
    public List<Order> listOrder(OrderVo orderVo);
    public void updateOrderWithUser(Order order);
    public Order findOrderByid(int id);
    public void deleteorderbyid(int id);
    public void updateOrderByid(Order order);
    public List<Order> listOrderbyuserid(int userid);
    public Order findOrderByTradenumber(String tradenumber);

}
