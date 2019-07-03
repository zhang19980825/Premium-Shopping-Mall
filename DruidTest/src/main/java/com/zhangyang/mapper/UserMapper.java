package com.zhangyang.mapper;

import com.zhangyang.vo.UserInfoRequest;
import com.zhangyang.vo.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 */
@Mapper
public interface UserMapper {

    UserInfoResponse getUserInfo(UserInfoRequest request);
}