package com.zhangyang.mapper;


import com.zhangyang.model.User;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/21 18:56
 */
public interface UserMapper {

    public void updateUser(User user);

    public User findByUserid(int id);

}
