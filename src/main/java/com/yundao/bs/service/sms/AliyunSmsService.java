package com.yundao.bs.service.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.yundao.bs.dto.sms.AliyunChannelDto;
import com.yundao.bs.dto.sms.SmsBatchDto;
import com.yundao.core.exception.BaseException;

/**
 * 阿里云短信发送服务接口
 *
 * @author jan
 * @create 2017-09-13 PM8:20
 **/
public interface AliyunSmsService {

    /**
     * 发送
     *
     * @param templateParam 短信模板参数
     * @param templateCdoe  短信编码
     * @param batchDto      批次发送
     * @param channelDto    短信通道
     */
    SendSmsResponse doSend(String templateParam, String templateCdoe, SmsBatchDto batchDto, AliyunChannelDto channelDto)
            throws BaseException;
}
