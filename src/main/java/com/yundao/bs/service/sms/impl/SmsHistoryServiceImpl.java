package com.yundao.bs.service.sms.impl;

import com.yundao.bs.mapper.sms.SmsHistoryMapper;
import com.yundao.bs.model.sms.SmsHistoryModel;
import com.yundao.bs.service.sms.SmsHistoryService;
import com.yundao.core.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信发送历史服务实现
 *
 * @author jan
 * @create 2017-08-17 PM2:53
 **/
@Service
public class SmsHistoryServiceImpl implements SmsHistoryService {

    @Autowired
    private SmsHistoryMapper smsHistoryMapper;

    @Override
    public void insert(List<SmsHistoryModel> models) throws BaseException {
        for (SmsHistoryModel model : models) {
            smsHistoryMapper.insert(model);
        }
    }
}
