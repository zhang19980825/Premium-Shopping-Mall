package com.zhangyang.vo;

import com.zhangyang.model.Order;
import com.zhangyang.model.OrderDetail;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/29 17:50
 */
public class OrderAll {
    private Order order;
    private OrderDetail orderDetail;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
