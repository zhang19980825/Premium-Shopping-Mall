package com.zhangyang.controller;

import com.zhangyang.model.Order;
import com.zhangyang.service.OrderService;
import com.zhangyang.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 17:08
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value="/insertOrder",method = RequestMethod.POST)
    public void  insertOrder(Order order){
        orderService.insertOrder(order);
    }

    @RequestMapping(value="/toinsertOrder",method = RequestMethod.GET)
    public String  toinsertOrder(Order order){
        return "insertOrder";
    }

    @RequestMapping(value="/listorder",method = RequestMethod.GET)
    public String listOrder(OrderVo orderVo, Model model){
        List<Order> list = orderService.listOrder(orderVo);
        model.addAttribute("orderlist",list);
        return "listorder";
    }

    @RequestMapping(value="/toupdateOrderInfo",method = RequestMethod.GET)
    public String toupdateOrderInfo(int id,Model model){
        Order order=orderService.findOrderByid(id);
        model.addAttribute("order",order);
        return "updateOrder";
    }

    @RequestMapping(value="/updateOrderInfo",method = RequestMethod.POST)
    public void updateOrderInfor(int id,String consigneeaddress,String consigneephone,String consigneename){
        orderService.updateOrderWithUser(id,consigneeaddress,consigneephone,consigneename);
    }


    @RequestMapping(value="/toviewOrder",method = RequestMethod.GET)
    public String  toviewOrder(Model model,int id){
        Order order=orderService.findOrderByid(id);
        model.addAttribute("order",order);
        return "viewOrder";
    }

    @RequestMapping(value="/toupdateOrderInfoWithMechart",method = RequestMethod.GET)
    public String toupdateOrderInfoWithMechart(int id,Model model){
        Order order=orderService.findOrderByid(id);
        model.addAttribute("order",order);
        return "updateOrderWithMechart.html";
    }

    @RequestMapping(value="/updateOrderInfoWithMechart",method = RequestMethod.POST)
    public void updateOrderInfoWithMechart(int id,String consigneeaddress,String consigneephone,String consigneename){
        orderService.updateOrderWithUser(id,consigneeaddress,consigneephone,consigneename);
    }

    @RequestMapping(value="/deleteorderbyid",method = RequestMethod.GET)
    public void deleteorderbyid(int id){
        orderService.deleteorderbyid(id);
    }


}
