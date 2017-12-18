package com.yundao.bs.service.sms.impl;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.yundao.bs.config.SmsConfig;
import com.yundao.bs.constant.DbCodeKeyConstant;
import com.yundao.bs.constant.SymbolConstant;
import com.yundao.bs.dto.sms.*;
import com.yundao.bs.enums.sms.SmsSendResultEnum;
import com.yundao.bs.mapper.base.BaseSmsResponseMapper;
import com.yundao.bs.model.base.BaseSmsResponse;
import com.yundao.bs.model.sms.SmsHistoryModel;
import com.yundao.bs.service.sms.*;
import com.yundao.bs.util.DesUtils;
import com.yundao.bs.util.SymbolStrUtils;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Sms服务实现
 *
 * @author jan
 * @create 2017-06-12 PM2:04
 **/
@Service
public class SmsServiceImpl extends AbstractService implements SmsService {

    private static Log log = LogFactory.getLog(SmsServiceImpl.class);

    @Autowired
    private SmsHistoryService smsHistoryService;

    @Autowired
    private BaseSmsResponseMapper baseSmsResponseMapper;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private SmsFilterAndCheckService smsFilterAndCheckService;

    @Autowired
    private AliyunSmsService aliyunSmsService;

    @Override
    public Result<Integer> doSend(SmsReqDto dto) throws BaseException {
        String logPrefix = "发送短信||默认通道||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));

        log.info("%s去重开始", logPrefix);
        this.distinct(dto);

        log.info("%s检查租户的短信功能是否被禁用", logPrefix);
        smsFilterAndCheckService.checkTenantSmsEnable();

        log.info("%s过滤手机号码开始", logPrefix);
        smsFilterAndCheckService.doFilter(dto);

        log.info("%s手机号码分组开始", logPrefix);
        SmsGroupDto groupDto = this.groupBy(dto);
        AliyunChannelDto channelDto = channelService.getDefaultChannel();
        SmsSendResult result = this.doSendByGroup(dto, groupDto, channelDto);
        //注意：tenantId 和 userId 有可能为Null的，要注意判断
        insertHistory(groupDto, dto, channelDto.getSign(), super.getHeaderTenantId(), super.getHeaderUserId());
        if (result.getSuccess())
            return Result.newSuccessResult(SmsSendResultEnum.SUCCESS.getValue());
        else
            return Result.newFailureResult();
    }

    /**
     * 分组发送
     */
    private SmsSendResult doSendByGroup(SmsReqDto dto, SmsGroupDto groupDto, AliyunChannelDto channelDto) throws
            BaseException {
        String logPrefix = "发送短信||分组调用阿里云发送||";
        SmsSendResult result = new SmsSendResult();

        boolean sendEnable = getSendEnableConf();
        log.info("%s sendEnable %s", logPrefix, sendEnable);
        //按分组发送
        for (SmsBatchDto batchDto : groupDto.getBatchs()) {
            SendSmsResponse sendSmsResponse;
            if (sendEnable) {
                sendSmsResponse = aliyunSmsService.doSend(dto.getTemplateParam(), dto.getTemplateCode(), batchDto, channelDto);
                log.info("%s 调用阿里云发送返回结果：%s", logPrefix, JsonUtils.objectToJson(sendSmsResponse));
            } else {
                //假装发送
                sendSmsResponse = sendFakeAndSuccess(batchDto.getBatchNo());
                log.info("%s 模拟发送成功");
            }
            result.setBatchNo(batchDto.getBatchNo());
            result.setSuccess(AliyunSmsResult.isSuccess(sendSmsResponse.getCode()));
            result.setMessage(sendSmsResponse.getMessage());
            //将阿里返回的bizid，当做批次id
            batchDto.setBatchNo(sendSmsResponse.getBizId());
            batchDto.setResultCode(sendSmsResponse.getCode());
            batchDto.setMessage(sendSmsResponse.getMessage());
        }
        log.info("%s完成", logPrefix);
        return result;
    }

    /**
     * 假装发送，并返回成功
     */
    private SendSmsResponse sendFakeAndSuccess(String batchNo) {
        SendSmsResponse sendSmsResponse = new SendSmsResponse();
        sendSmsResponse.setCode("OK");
        sendSmsResponse.setMessage("[模拟发送]OK");
        sendSmsResponse.setBizId(batchNo);
        return sendSmsResponse;
    }

    private boolean getSendEnableConf() {
        String sendEnableConf = ConfigUtils.getValue("sms.send.enable");
        if (BooleanUtils.isBlank(sendEnableConf))
            return false;
        if (sendEnableConf.trim().equals("1"))
            return true;
        else
            return false;
    }

    private void insertHistory(SmsGroupDto groupDto, SmsReqDto dto, String sign, Long tenantId, Long userId) {
        ThreadUtils.execute(() -> {
            try {
                //保存发送历史
                this.insertHistries(groupDto, dto, sign, tenantId, userId);
            } catch (Exception ex) {
                log.error("insertHistries 异常：%s", ex.toString());
            }
        });
    }

    @Override
    public Result<Integer> doSendWithAccount(SmsWithAccountReqDto dto) throws BaseException {
        String logPrefix = "发送短信||自定义通道||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));

        log.info("%s去重开始", logPrefix);
        this.distinct(dto);

        log.info("%s过滤手机号码开始", logPrefix);
        smsFilterAndCheckService.doFilter(dto);

        log.info("%s手机号码分组开始", logPrefix);
        SmsGroupDto groupDto = this.groupBy(dto);
        AliyunChannelDto channelDto = new AliyunChannelDto();
        channelDto.setSign(dto.getSign());
        channelDto.setAccessKeyId(DesUtils.decrypt(dto.getAccessKeyId()));
        channelDto.setAccessKeySecret(DesUtils.decrypt(dto.getAccessKeySecret()));
        SmsSendResult result = this.doSendByGroup(dto, groupDto, channelDto);
        //注意：tenantId 和 userId 有可能为Null的，要注意判断
        insertHistory(groupDto, dto, channelDto.getSign(), super.getHeaderTenantId(), super.getHeaderUserId());
        if (result.getSuccess())
            return Result.newSuccessResult(SmsSendResultEnum.SUCCESS.getValue());
        else
            return Result.newFailureResult();
    }


    /**
     * 将手机号码分组
     *
     * @param smsDto 短信dto
     * @return 分组后的数据
     */
    private SmsGroupDto groupBy(SmsReqDto smsDto) throws BaseException {
        log.info("将手机号码分组开始,smsDto:%s", JsonUtils.objectToJson(smsDto));
        SmsConfig smsConfig = SmsConfig.get();
        //所有需要发送的手机号码
        List<String> mobiles = Arrays.asList(smsDto.getMobiles().split(SymbolConstant.COMMA));
        SmsGroupDto result = new SmsGroupDto();
        List<SmsBatchDto> batchs = new ArrayList<>();
        //流水号
        result.setSeqNo("SEQ" + this.getSerialNo());
        //每组多少个号码
        int splitNumber = smsConfig.getOnceMaxCount();
        StringBuilder sb = new StringBuilder();
        int count = mobiles.size();
        for (int i = 0; i < count; i++) {
            sb.append(mobiles.get(i));
            if ((i + 1) % splitNumber == 0 || (i + 1) == count) {
                SmsBatchDto batchDto = new SmsBatchDto();
                //批次号
                batchDto.setBatchNo(this.getSerialNo());
                batchDto.setMobiles(sb.toString());
                log.info("批次号：%s,%s", batchDto.getBatchNo(), sb.toString());
                batchs.add(batchDto);
                sb = new StringBuilder();
            } else {
                sb.append(SymbolConstant.COMMA);
            }
        }
        result.setBatchs(batchs);
        log.info("手机号分组结果:%s", JsonUtils.objectToJson(result));
        return result;
    }

    /**
     * 获取序列号
     *
     * @return 序列号
     */
    private String getSerialNo() {
        String result = DateUtils.getCurrentTime(DateUtils.YYMMDDHHMMSSSSS);
        Random rnd = new Random();
        int num = 100 + rnd.nextInt(900);
        result += num;
        return result;
    }

    /**
     * 去重
     */
    private void distinct(SmsReqDto reqDto) throws BaseException {
        List<String> mobileList = SymbolStrUtils.toList(reqDto.getMobiles());
        HashSet hash = new HashSet(mobileList);
        List<String> newList = new ArrayList<>();
        newList.addAll(hash);
        reqDto.setMobiles(SymbolStrUtils.toStr(newList));
    }

    /**
     * 保存发送历史
     */
    private void insertHistries(SmsGroupDto groupDto, SmsReqDto reqDto, String sign, Long tenantId, Long userId) throws BaseException {
        log.begin("groupDto:%s", JsonUtils.objectToJson(groupDto));
        log.info("执行插入历史记录 开始");
        List<SmsBatchDto> batchs = groupDto.getBatchs();
        List<SmsHistoryModel> histories = new ArrayList<>();
        for (SmsBatchDto batch : batchs) {
            BaseSmsResponse response = new BaseSmsResponse();
            super.initialModel(response);
            response.setSeqId(groupDto.getSeqNo());
            response.setBizId(batch.getBatchNo());
            response.setCode(batch.getResultCode());
            response.setMessage(batch.getMessage());
            response.setTemplateCode(reqDto.getTemplateCode());
            response.setTemplateParam(reqDto.getTemplateParam());
            response.setSign(sign);
            response.setSmstype(reqDto.getSmsType());
            response.setTenantId(tenantId);
            response.setCreateUserId(userId);
            baseSmsResponseMapper.insertSelective(response);
            List<String> mobileList = SymbolStrUtils.toList(batch.getMobiles());

            for (String mobile : mobileList) {
                SmsHistoryModel history = new SmsHistoryModel();
                super.initialModel(history);
                history.setMobileStr(mobile);
                history.setResponseId(response.getId());
                history.setDbCodeKey(DbCodeKeyConstant.MOBILE);
                history.setTenantId(tenantId);
                history.setCreateUserId(userId);
                histories.add(history);
            }
        }
        smsHistoryService.insert(histories);
        log.info("执行插入历史记录 结束");
        log.end();
    }
}
