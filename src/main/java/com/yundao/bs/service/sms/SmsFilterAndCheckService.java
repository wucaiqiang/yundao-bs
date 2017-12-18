package com.yundao.bs.service.sms;

import com.yundao.bs.dto.sms.SmsReqDto;
import com.yundao.core.exception.BaseException;

import java.util.List;

/**
 * 短信发送前检查服务接口
 *
 * @author jan
 * @create 2017-09-13 PM7:45
 **/
public interface SmsFilterAndCheckService {

    /**
     * 检查该租户发送短信功能是否被禁用
     */
    void checkTenantSmsEnable() throws BaseException;

    /**
     * 过滤手机号码
     */
    void doFilter(SmsReqDto smsDto) throws BaseException;

    /**
     * 过滤格式错误的手机号码
     */
    List<String> filterFormatError(List<String> mobiles) throws BaseException;

    /**
     * 过滤黑名单的手机号码
     */
    List<String> filterBlackList(List<String> mobiles, String blackListMobiles) throws BaseException;

}
