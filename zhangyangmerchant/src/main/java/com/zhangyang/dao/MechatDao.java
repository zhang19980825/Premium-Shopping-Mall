package com.zhangyang.dao;

import com.zhangyang.mapper.MechantMapper;
import com.zhangyang.model.Mechant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/23 15:36
 */
@Component
public class MechatDao {
    @Autowired
    MechantMapper mechantMapper;
    public void insertMechant(Mechant mechant){
        mechantMapper.insertMechant(mechant);
    }
    public void updateMechant(Mechant mechant){
        mechantMapper.updateMechant(mechant);
    }
    public Mechant findMechantbyid(int id){
        return mechantMapper.findMechantbyid(id);
    }
    public void updateMechantstatus(Mechant mechant){
        mechantMapper.updateMechantstatus(mechant);
    }
    public void updatesoldout(Mechant mechant){
        mechantMapper.updatesoldout(mechant);
    }
}
