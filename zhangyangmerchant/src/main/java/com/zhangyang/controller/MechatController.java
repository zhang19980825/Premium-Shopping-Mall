package com.zhangyang.controller;

import com.zhangyang.model.Mechant;
import com.zhangyang.service.MechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/23 15:39
 */
@Controller
public class MechatController {
    @Autowired
    MechatService mechatService;

    @RequestMapping(value="/insertMechant",method = RequestMethod.POST)
    public void insertMechant(Mechant mechant){
        mechatService.insertMechant(mechant);
    }

    @RequestMapping(value="/toinsertMechant",method = RequestMethod.GET)
    public String toinsertMechant(Mechant mechant) {
        return "mechantregister";
    }

    @RequestMapping(value="/toupdateMechant",method = RequestMethod.GET)
    public String toupdateMechant(Model model,int id){
        Mechant mechant= mechatService.findMechantbyid(id);
        model.addAttribute("mechant",mechant);
        return "mechantupdate";
    }

    @RequestMapping(value="/updateMechant",method = RequestMethod.POST)
    public void updateMechant(Mechant mechant){
        mechatService.updateMechant(mechant);

    }

    @RequestMapping(value="/findMechantbyid",method = RequestMethod.GET)
    public String findMechantbyid(Model model,int id){
        Mechant mechant= mechatService.findMechantbyid(id);
        model.addAttribute("mechant",mechant);
        return "mechantview.html";
    }

    @RequestMapping(value="/updateMechantstatus",method = RequestMethod.POST)
    public void updateMechantstatus(int status,int id){
        mechatService.updateMechantstatus(status,id);
    }

    @RequestMapping(value="/toupdateMechantstatus",method = RequestMethod.GET)
    public String toupdateMechantstatus(int status,int id,Model model){
        Mechant mechant= mechatService.findMechantbyid(id);
        model.addAttribute("mechant",mechant);
        return "mechantaudit";
    }

    @RequestMapping(value="/updatesoldout",method = RequestMethod.POST)
    public void updatesoldout(int status,int id){
        mechatService.updatesoldout(status,id);
    }

    @RequestMapping(value="/toupdatesoldout",method = RequestMethod.GET)
    public String toupdatesoldout(Model model,int id){
        Mechant mechant= mechatService.findMechantbyid(id);
        model.addAttribute("mechant",mechant);
        return "mechantsoldout";
    }
}
