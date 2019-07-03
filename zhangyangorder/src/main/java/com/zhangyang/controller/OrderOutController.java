package com.zhangyang.controller;

import com.zhangyang.model.Order;
import com.zhangyang.model.OrderDetail;
import com.zhangyang.service.OrderDetailService;
import com.zhangyang.service.OrderService;
import com.zhangyang.vo.OrderAll;
import com.zhangyang.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:08
 */
@RestController
public class OrderOutController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping(value="/insertoutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Integer  insertoutOrder(@RequestBody OrderAll orderAll){
        Order order=orderAll.getOrder();
        OrderDetail orderDetail=orderAll.getOrderDetail();
        orderService.insertOrder(order);
        orderDetail.setCreatetime(order.getCreatetime());
        orderDetail.setOrderid(order.getId());
        orderDetailService.insertOrderDetail(orderDetail);
        return order.getId();
    }

    @RequestMapping(value="/findOrderByid",method = RequestMethod.POST)
    @ResponseBody
    public Order findOrderByid(@RequestParam int id){
        Order order=orderService.findOrderByid(id);
        return order;
    }

    @RequestMapping(value = "/updateorderstatebyid",method = RequestMethod.POST)
    public void updateorderstatebyid(@RequestParam int id,@RequestParam int paytype,@RequestParam int paystatus){
        Order order = new Order();
        order.setId(id);
        order.setPaytype(paytype);
        order.setPaystatus(paystatus);
        orderService.updateOrderByid(order);
    }

    @RequestMapping(value = "/findorderByuserid",method = RequestMethod.POST)
    public List<Order> findorderByuserid(@RequestParam int userid){
        List<Order> order=orderService.listOrderbyuserid(userid);
        return order;
    }


    @RequestMapping(value = "/findOrderByTradenumber",method = RequestMethod.POST)
    public Order findOrderByTradenumber(String tradenumber){
        return orderService.findOrderByTradenumber(tradenumber);
    }





}
