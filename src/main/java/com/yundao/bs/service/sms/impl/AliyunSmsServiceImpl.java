package com.yundao.bs.service.sms.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.yundao.bs.constant.CodeConstant;
import com.yundao.bs.dto.sms.AliyunChannelDto;
import com.yundao.bs.dto.sms.SmsBatchDto;
import com.yundao.bs.service.sms.AliyunSmsService;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import org.springframework.stereotype.Service;

/**
 * 阿里云短信服务
 *
 * @author jan
 * @create 2017-08-16 PM2:32
 **/
@Service
public class AliyunSmsServiceImpl implements AliyunSmsService {

    private static Log log = LogFactory.getLog(AliyunSmsServiceImpl.class);

    @Override
    public SendSmsResponse doSend(String templateParam, String templateCdoe, SmsBatchDto batchDto, AliyunChannelDto
            channelDto) throws BaseException {
    /*    SendSmsResponse response = new SendSmsResponse();
        response.setBizId("12341234132^1");
        response.setCode("OK");
        response.setMessage("成功");
        response.setRequestId("242134-4123-324132-34234");
        return response;*/

        log.info("开始发送短信 batchDto：%s，templateParam：%s，templateCode:%s，channelDto:%s", JsonUtils.objectToJson(batchDto), templateParam, templateCdoe, JsonUtils.objectToJson(channelDto));
        //产品名称:云通信短信API产品,开发者无需替换
        final String product = "Dysmsapi";
        //产品域名,开发者无需替换
        final String domain = "dysmsapi.aliyuncs.com";
        //地区
        final String region = "cn-hangzhou";
        try {
            IClientProfile profile = DefaultProfile.getProfile(region, channelDto.getAccessKeyId(), channelDto.getAccessKeySecret());
            DefaultProfile.addEndpoint(region, region, product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            SendSmsRequest request = new SendSmsRequest();
            request.setPhoneNumbers(batchDto.getMobiles());
            //短信签名
            request.setSignName(channelDto.getSign());
            request.setTemplateCode(templateCdoe);
            request.setTemplateParam(templateParam);

            SendSmsResponse response = acsClient.getAcsResponse(request);
            log.info("调用阿里云短信平台发送结果：%s", JsonUtils.objectToJson(response));
            return response;
        } catch (Exception ex) {
            log.error("批次号：%s,发送短信异常：%s", batchDto.getBatchNo(), ex.toString());
            throw new BaseException(CodeConstant.CODE_1100012);
        }

    }
}
