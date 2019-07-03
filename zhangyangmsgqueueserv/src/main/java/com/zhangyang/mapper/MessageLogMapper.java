package com.zhangyang.mapper;

import com.zhangyang.model.MessageLog;
import com.zhangyang.model.ProductType;
import com.zhangyang.model.MessageLog;

import java.util.List;

/**
 * Created by zhangyang on 2018/6/8 0008.
 */
public interface MessageLogMapper {
    public void insertMessageLog(MessageLog messageLog);
    public void updateMessageLog(MessageLog messageLog);
}
