package com.zhangyang.service;

import com.zhangyang.dao.OrderDao;
import com.zhangyang.model.Order;
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
public class OrderService {
    @Autowired
    OrderDao orderDao;
    public void  insertOrder(Order order){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        String datastring=dateFormat.format(date);
        String tradenumber=UUID.randomUUID()+datastring;
        order.setCreatetime(date);
        order.setTradenumber(tradenumber);
        order.setOrderstatus(0);
        order.setPaystatus(1);
        orderDao.insertOrder(order);
    }
    public List<Order> listOrder(OrderVo orderVo){
        return orderDao.listOrder(orderVo);
    }
    public void updateOrderWithUser(int id,String consigneeaddress,String consigneephone,String consigneename){
        Order order=new Order();
        order.setId(id);
        order.setConsigneeaddress(consigneeaddress);
        order.setConsigneephone(consigneephone);
        order.setConsigneename(consigneename);
        orderDao.updateOrderWithUser(order);
    }
    public Order findOrderByid(int id){
        return orderDao.findOrderByid(id);
    }
    public void deleteorderbyid(int id){
        orderDao.deleteorderbyid(id);
    }

    public void updateOrderByid(Order order){
        order.setPaytime(new Date());
        orderDao.updateOrderByid(order);
    }

    public List<Order> listOrderbyuserid(int userid){
        return orderDao.listOrderbyuserid(userid);
    }

    public Order findOrderByTradenumber(String tradenumber){
        return orderDao.findOrderByTradenumber(tradenumber);
    }
}
