package com.zhangyang.service;

import com.zhangyang.model.Order;
import com.zhangyang.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@FeignClient(value = "zhangyangorder")
public interface OrderService {

    @RequestMapping(value="/insertoutOrder",method = RequestMethod.POST)
    public void  insertoutOrder(@RequestBody OrderAll orderAll);

    @RequestMapping(value="/findOrderByid",method = RequestMethod.POST)
    public Order findOrderByid(@RequestParam(value = "id")  int id);

    @RequestMapping(value = "/updateorderstatebyid",method = RequestMethod.POST)
    public void updateorderstatebyid(@RequestParam(value = "id") int id,@RequestParam(value = "paytype") int paytype,@RequestParam(value = "paystatus") int paystatus);

}
