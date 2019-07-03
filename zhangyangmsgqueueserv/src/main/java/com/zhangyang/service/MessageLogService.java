package com.zhangyang.service;


import com.zhangyang.dao.MessageLogDao;
import com.zhangyang.model.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyang on 2018/6/8 0008.
 */
@Component
public class MessageLogService {

    @Autowired
    MessageLogDao messageLogDao;

    public void insertMessageLog(MessageLog messageLog){

        messageLogDao.insertMessageLog(messageLog);
    };
    public void updateMessageLog(MessageLog messageLog){

        messageLogDao.updateMessageLog(messageLog);
    };
}
