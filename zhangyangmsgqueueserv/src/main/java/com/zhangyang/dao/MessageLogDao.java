package com.zhangyang.dao;



import com.zhangyang.mapper.MessageLogMapper;
import com.zhangyang.model.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by zhangyang on 2018/6/8 0008.
 */
@Component
public class MessageLogDao {

    @Autowired
    MessageLogMapper messageLogMapper;

    public void insertMessageLog(MessageLog messageLog){
        messageLogMapper.insertMessageLog(messageLog);
    };
    public void updateMessageLog(MessageLog messageLog){
        messageLogMapper.updateMessageLog(messageLog);
    };
}
