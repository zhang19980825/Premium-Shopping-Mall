package com.zhangyang.service;



import com.zhangyang.model.Order;
import com.zhangyang.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/6/18 0018.
            */
    @FeignClient(value = "zhangyangorder")
    public interface OrderService {

        @RequestMapping(value = "/insertoutOrder",method = RequestMethod.POST)
        public  Integer insertOutOrder(@RequestBody OrderAll orderAll);

        @RequestMapping(value = "/findOrderByTradenumber",method = RequestMethod.POST)
        public Order findOrderByTradenumber(@RequestParam(value = "tradenumber") String tradenumber);
}
