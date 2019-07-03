package com.zhangyang.dao;

import com.zhangyang.mapper.UserMapper;
import com.zhangyang.model.User;
import com.zhangyang.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/21 20:57
 */
@Component
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    public void insertuserInfo(User user) {
        userMapper.insertuserInfo(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findByUserid(int id) {
        return userMapper.findByUserid(id);
    }

    public List<User> queryuserbyvo(UserVo userVo) {
        return userMapper.queryuserbyvo(userVo);
    }

    public void deleteuserbyid(int id) {
        userMapper.deleteuserbyid(id);
    }

    public User findByUsername(String name){
        return userMapper.findByUsername(name);
    }
}
