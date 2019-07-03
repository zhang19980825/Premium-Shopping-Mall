package com.zhangyang.service;

import com.zhangyang.dao.MechatDao;
import com.zhangyang.model.Mechant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/23 15:38
 */
@Service
public class MechatService {
    @Autowired
    MechatDao mechatDao;
    public void insertMechant(Mechant mechant){
        mechant.setAuditstatus(1);
        mechant.setSoldout(1);
        mechatDao.insertMechant(mechant);
    }
    public void updateMechant(Mechant mechant){
        mechant.setSoldout(1);
        mechatDao.updateMechant(mechant);
    }
    public Mechant findMechantbyid(int id){
        return mechatDao.findMechantbyid(id);
    }
    public void updateMechantstatus(int status,int id){
        Mechant mechant=new Mechant();
        mechant.setId(id);
        mechant.setAuditstatus(status);
        mechatDao.updateMechantstatus(mechant);
    }

    //商家是否审核成功
    public void updatesoldout(int status,int id){
        Mechant mechant=new Mechant();
        mechant.setId(id);
        mechant.setSoldout(status);
        mechatDao.updatesoldout(mechant);
    }
}
