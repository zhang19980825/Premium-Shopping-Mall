package com.zhangyang.dao;

import com.zhangyang.mapper.MsgMapper;

import com.zhangyang.model.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MsgDao {
    @Autowired
    MsgMapper msgMapper;

    public List<MessageLog> listbyywmessagestatus(int ywmessagestatus){
       return msgMapper.listbyywmessagestatus(ywmessagestatus);
    }

    public List<MessageLog> listbyall(){
            return msgMapper.listbyall();
    }

}
