package com.zhangyang.service;

import com.zhangyang.model.Order;
import com.zhangyang.model.OrderDetail;
import com.zhangyang.model.Product;
import com.zhangyang.model.ProductDetail;
import com.zhangyang.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@FeignClient(value = "zhangyangorder")
public interface OrderService {

    @RequestMapping(value="/insertoutOrder",method = RequestMethod.POST)
    public Integer insertoutOrder(@RequestBody OrderAll orderAll);

    @RequestMapping(value = "/findorderByuserid",method = RequestMethod.POST)
    public List<Order> findorderByuserid(@RequestParam(value = "userid") int userid);
}
