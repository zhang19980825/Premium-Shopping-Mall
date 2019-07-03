package com.zhangyang.controller;

import com.zhangyang.hystrix.ProductTypeServicehystrix;
import com.zhangyang.model.*;
import com.zhangyang.service.OrderMsgOutService;
import com.zhangyang.service.OrderService;
import com.zhangyang.service.ProductService;
import com.zhangyang.vo.OrderAll;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:18
 */
@Controller
public class IndexController {

    @Autowired
    ProductService productService;

    /*@Autowired
    ProductTypeService productTypeService;*/

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMsgOutService orderMsgOutService;

    @Autowired
    ProductTypeServicehystrix productTypeServicehystrix;


    @RequestMapping(value = "/indexproduct",method = RequestMethod.GET)
    public String sayHi(Model model,@RequestParam int producttypeid){
        List<ProductType> list=productTypeServicehystrix.listproductType();
        System.out.println(list);
        model.addAttribute("producttypelist",list);
        if(producttypeid==1){
            producttypeid=list.get(0).getId();
        }
        List<Product> productlist=productService.listproduct(producttypeid);
        System.out.println(list);
        model.addAttribute("productlist",productlist);
        return "list";
    }

    @RequestMapping(value = "/searchproductout",method = RequestMethod.POST)
    public String searchproductout(Model model,@RequestParam String keyword){
        List<Product> list=productService.searchproductout(keyword);
        model.addAttribute("productlist",list);
        return "list";
    }

    @RequestMapping(value = "/toproductdetail",method = RequestMethod.GET)
    public String toproductdetail(Model model,@RequestParam int producttypeid,@RequestParam int productid){
        List<ProductType> list=productTypeServicehystrix.listproductType();
        model.addAttribute("producttypelist",list);
        if(producttypeid==1){
            producttypeid=list.get(0).getId();
        }
        Product product=productService.viewoutProduct(productid);
        System.out.println(list);
        model.addAttribute("product",product);

        ProductDetail productDetail=productService.findproductdetailbyid(productid);
        model.addAttribute("productDetail",productDetail);
        return "productdetail";
    }

    @RequestMapping(value = "/tobuy",method = RequestMethod.GET)
    public String tobuy(Model model,@RequestParam int productid,@RequestParam int num){
            List<ProductType> list=productTypeServicehystrix.listproductType();
            model.addAttribute("producttypelist",list);
            Product product=productService.viewoutProduct(productid);
            model.addAttribute("product",product);
            int price=product.getProductprice(); //商品价格
            double totalamount=price*num; //总金额
            model.addAttribute("totalamount",totalamount);
            model.addAttribute("num",num);
        return "insertOrder";
    }

    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    public String insertOrder(Model model, HttpServletRequest req, int num, int productid, double payamount, int mechartid, String consigneeadress, String consigneename, String consigneephone){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            return "login";
        }else {
            Order order = new Order();
            User userreal = (User)user;
            int userid = userreal.getId();
            order.setUserid(userid);
            order.setPayamount(payamount);
            order.setConsigneename(consigneename);
            order.setConsigneephone(consigneephone);
            order.setConsigneeaddress(consigneeadress);
            DateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            String nowdatestring=dataFormat.format(new Date());
            String trademenber=UUID.randomUUID()+nowdatestring;
            order.setTradenumber(trademenber);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductid(productid);
            orderDetail.setMechartid(mechartid);
            orderDetail.setTradenum(num);
            OrderAll orderAll = new OrderAll();
            orderAll.setOrder(order);
            orderAll.setOrderDetail(orderDetail);
          /*  int orderid=orderService.insertoutOrder(orderAll);
            model.addAttribute("orderid",orderid);*/
            orderMsgOutService.sendordermsgbyobj(orderAll);
            List<Order> listorder = orderService.findorderByuserid(userid);
            model.addAttribute("listorder",listorder);
            return "listorder";
        }
    }


    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    public String payOrder(Model model, HttpServletRequest req,int orderid,int paytype){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            return "login";
        }else {
            if(1==paytype){//微信支付
                String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx705762491229630b&redirect_uri=http://zhangyang.natapp1.cc/  ?orderid="+orderid+"&response_type=code&scope=snsapi_base&connect_redirect=1#wechat_redirect";
                RestTemplate restTemplate = new RestTemplate();
                String response = restTemplate.getForObject(url, String.class);
                System.out.println(response);
            }
            return "list";
        }
    }


    @RequestMapping(value = "/listorderbyuserid",method = RequestMethod.GET)
    public String listorderbyuserid(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            return "login";
        }else {
            User userreal = (User)user;
            int userid = userreal.getId();
            List<Order> listorder = orderService.findorderByuserid(userid);
            model.addAttribute("listorder",listorder);
//            return "payorder";
            return "listorder";
        }
    }



}
