package com.yundao.bs.service.sms;


import com.yundao.bs.dto.sms.AliyunChannelDto;
import com.yundao.core.exception.BaseException;

/**
 * 通道服务接口
 *
 * @author jan
 * @create 2017-06-12 PM5:02
 **/
public interface ChannelService {

    /**
     * 获取默认的短信通道
     *
     * @return 短信通道
     */
    AliyunChannelDto getDefaultChannel() throws BaseException;

}

