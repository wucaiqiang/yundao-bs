package com.yundao.bs.service.sms.impl;

import com.yundao.bs.constant.CodeConstant;
import com.yundao.bs.dto.sms.AliyunChannelDto;
import com.yundao.bs.service.sms.ChannelService;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.DesUtils;
import org.springframework.stereotype.Service;

/**
 * 通道服务实现
 *
 * @author jan
 * @create 2017-06-12 PM5:03
 **/
@Service
public class ChannelServiceImpl implements ChannelService {

    private static Log log = LogFactory.getLog(ChannelServiceImpl.class);

    @Override
    public AliyunChannelDto getDefaultChannel() throws BaseException {
        log.begin();
        AliyunChannelDto dto = new AliyunChannelDto();
        String akId = ConfigUtils.getValue("sms.aliyun.accesskeyid");
        String aks = ConfigUtils.getValue("sms.aliyun.accesskeysecret");
        String sign = ConfigUtils.getValue("sms.sign.name");
        log.info("akId:%s,aks:%s,sign:%s", akId, aks, sign);
        try {
            akId = DesUtils.decrypt(akId);
            aks = DesUtils.decrypt(aks);
        } catch (Exception ex) {
            log.error("des decrypt 异常：%s", ex.toString());
            throw new BaseException(CodeConstant.CODE_1100014);
        }
        dto.setSign(sign);
        dto.setAccessKeyId(akId);
        dto.setAccessKeySecret(aks);
        log.end();
        return dto;
    }
}
