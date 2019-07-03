package com.zhangyang.mapper;

import com.zhangyang.model.MessageLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MsgMapper {
  public List<MessageLog> listbyywmessagestatus(int ywmessagestatus);

    public List<MessageLog> listbyall();

}
