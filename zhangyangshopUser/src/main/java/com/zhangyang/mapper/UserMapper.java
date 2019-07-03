package com.zhangyang.mapper;


import com.zhangyang.model.User;
import com.zhangyang.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/21 18:56
 */
@Mapper
public interface UserMapper {
    public User findUserInfo();

    public void insertuserInfo(User user);

    public void updateUser(User user);

    public User findByUserid(int id);

    public List<User> queryuserbyvo(UserVo userVo);

    public void deleteuserbyid(int id);

    public User findByUsername(String name);
}
