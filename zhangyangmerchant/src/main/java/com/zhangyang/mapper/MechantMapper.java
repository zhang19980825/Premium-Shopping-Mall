package com.zhangyang.mapper;

import com.zhangyang.model.Mechant;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/23 15:28
 */
public interface MechantMapper {
    public void insertMechant(Mechant mechant);
    public void updateMechant(Mechant mechant);
    public Mechant findMechantbyid(int id);
    public void updateMechantstatus(Mechant mechant);
    public void updatesoldout(Mechant mechant);

}
