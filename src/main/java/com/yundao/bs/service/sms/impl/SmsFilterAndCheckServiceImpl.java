package com.yundao.bs.service.sms.impl;

import com.yundao.bs.config.SmsConfig;
import com.yundao.bs.constant.CodeConstant;
import com.yundao.bs.constant.SymbolConstant;
import com.yundao.bs.dto.sms.SmsReqDto;
import com.yundao.bs.service.sms.SmsFilterAndCheckService;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.RegularUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 短信发送前检查服务实现
 *
 * @author jan
 * @create 2017-09-13 PM7:49
 **/
@Service
public class SmsFilterAndCheckServiceImpl extends AbstractService implements SmsFilterAndCheckService {

    private static Log log = LogFactory.getLog(SmsFilterAndCheckServiceImpl.class);

    @Override
    public void checkTenantSmsEnable() throws BaseException {
        String logPrefix = "短信发送检查||";
        //检查此租户是否被禁止使用短信功能
        SmsConfig config = SmsConfig.get();
        log.info("%s配置信息 %s", logPrefix, JsonUtils.objectToJson(config));
        Long tenantId = super.getHeaderTenantId();
        log.info("%s租户id%s", logPrefix, tenantId);
        if (tenantId != null) {
            String tenantIdStr = config.getBlacklistTenant();
            if (BooleanUtils.isNotEmpty(tenantIdStr)) {
                List<String> tenantIds = Arrays.asList(tenantIdStr.split(SymbolConstant.COMMA));
                if (tenantIds.contains(tenantId.toString())) {
                    log.info("%s该租户短信功能被禁用", logPrefix);
                    throw new BaseException(CodeConstant.CODE_1100000);
                }
            }
        }
        log.info("%s执行完成", logPrefix);
    }

    @Override
    public void doFilter(SmsReqDto smsDto) throws BaseException {
        log.info("过滤手机号码 开始 smsDto:%s", JsonUtils.objectToJson(smsDto));
        SmsConfig smsConfig = SmsConfig.get();
        List<String> mobiles = Arrays.asList(smsDto.getMobiles().split(SymbolConstant.COMMA));

        //过滤手机格式错误的号码
        mobiles = this.filterFormatError(mobiles);
        if (BooleanUtils.isEmpty(mobiles)) {
            log.info("过滤掉格式错误号码后，需要发送的号码为空");
            return;
            //throw new BaseException(CodeConstant.CODE_1100002);
        }

        //手机号码黑名单
        String mobilesStr = smsConfig.getBlacklistMobile();
        if (BooleanUtils.isNotEmpty(mobilesStr)) {
            mobiles = this.filterBlackList(mobiles, mobilesStr);
            if (BooleanUtils.isEmpty(mobiles)) {
                log.info("过滤掉黑名单后，需要发送的号码为空");
                return;
                //throw new BaseException(CodeConstant.CODE_1100003);
            }
        }
        smsDto.setMobiles(String.join(SymbolConstant.COMMA, mobiles));
        log.info("手机号码过滤结果:%s", JsonUtils.objectToJson(smsDto));
    }

    @Override
    public List<String> filterFormatError(List<String> mobiles) throws BaseException {
        List<String> legalMobiles = new ArrayList<>();
        String errMobiles = "";
        for (String mobile : mobiles) {
            if (BooleanUtils.isEmpty(mobile))
                continue;
            if (!RegularUtils.isMatch(mobile, RegularUtils.Regular.MOBILE)) {
                errMobiles += mobile + ",";
                continue;
            }
            legalMobiles.add(mobile);
        }
        if (BooleanUtils.isNotEmpty(errMobiles))
            log.info("filterFormatError 格式错误手机号码：%s", errMobiles);
        return legalMobiles;
    }

    @Override
    public List<String> filterBlackList(List<String> mobiles, String blackListMobiles) throws BaseException {
        List<String> blackListMobile = Arrays.asList(blackListMobiles.split(SymbolConstant.COMMA));
        List<String> legalMobiles = new ArrayList<>();
        for (String mobile : mobiles) {
            if (!blackListMobile.contains(mobile)) {
                legalMobiles.add(mobile);
            }
        }
        return legalMobiles;
    }
}
