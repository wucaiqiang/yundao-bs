package com.yundao.bs.service.sms;


import com.yundao.bs.dto.sms.SmsReqDto;
import com.yundao.bs.dto.sms.SmsWithAccountReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;

/**
 * Sms服务接口
 *
 * @author jan
 * @create 2017-06-12 PM2:02
 **/

public interface SmsService {

    /**
     * 发送短信
     *
     * @param dto 短信请求数据
     * @return 发送结果
     * @throws BaseException 异常信息
     */
    Result<Integer> doSend(SmsReqDto dto) throws BaseException;

    /**
     * 使用自定义账号发送短信
     *
     * @param dto 短信请求数据
     * @return 发送结果
     * @throws BaseException 异常信息
     */
    Result<Integer> doSendWithAccount(SmsWithAccountReqDto dto) throws BaseException;

}
