package com.yundao.bs.service.sms;

import com.yundao.bs.model.sms.SmsHistoryModel;
import com.yundao.core.exception.BaseException;

import java.util.List;

/**
 * 短信发送历史服务接口
 *
 * @author jan
 * @create 2017-08-17 PM2:52
 **/
public interface SmsHistoryService {

    /**
     * 插入
     */
    void insert(List<SmsHistoryModel> models) throws BaseException;

}
