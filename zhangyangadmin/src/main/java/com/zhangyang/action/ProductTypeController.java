package com.zhangyang.action;

import com.zhangyang.model.ProductType;
import com.zhangyang.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:18
 */
@Controller
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/listproducttype",method = RequestMethod.GET)
    public String listproductouttype(Model model){
        List<ProductType> list=productTypeService.listproductType();
        model.addAttribute("producttypelist",list);
        System.out.println(list);
        return "listtype";
    }

    @RequestMapping(value = "/listproducttypebypr",method = RequestMethod.GET)
    public String listproducttypebypr(Model model){
        List<ProductType> list=productTypeService.listproductType();
        model.addAttribute("producttypelist",list);
        System.out.println(list);
        return "listtypebypr";
    }

    @RequestMapping(value = "/toinsertProducttype",method = RequestMethod.GET)
    public String toinsertoutProducttype(){
        return "producttypeadd";
    }

    @RequestMapping(value = "/insertProducttype",method = RequestMethod.POST)
    public void insertProducttype( ProductType productType){
        productTypeService.insertProducttype(productType);
    }

    @RequestMapping(value = "/findProducttypeByid",method = RequestMethod.GET)
    public String findProductytpeByid(@RequestParam(value = "id") int id,Model model){
        ProductType productType=productTypeService.findProductytpeByid(id);
        model.addAttribute("productType",productType);
        return "producttypeview";
    }


    @RequestMapping(value = "/toupdateProducttytpeByid",method = RequestMethod.GET)
    public String toupdateProductytpeByid(@RequestParam int id,Model model){
        ProductType productType=productTypeService.findProductytpeByid(id);
        model.addAttribute("productType",productType);
        return "producttypeupdate";
    }

    @RequestMapping(value = "/updateProducttypeByid",method = RequestMethod.POST)
    public void updateProductytpeByid(ProductType productType){
        productTypeService.updateProductytpeByid(productType);
    }
}
