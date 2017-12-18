package com.yundao.bs.controller.sms;

import com.yundao.bs.config.SmsConfig;
import com.yundao.bs.dto.sms.SmsReqDto;
import com.yundao.bs.dto.sms.SmsWithAccountReqDto;
import com.yundao.bs.service.sms.SmsService;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 短信操作控制器
 *
 * @author jan
 * @create 2017-06-15 PM6:47
 **/
@Controller
@ResponseBody
@RequestMapping("/sms")
@Api("SMS短信")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信", notes = "支持同时发送多条")
    public Result<Integer> send(@Validated @ModelAttribute SmsReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        Result<Integer> result = smsService.doSend(dto);
        return result;
    }

    @RequestMapping(value = "/send_with_account", method = RequestMethod.POST)
    @ApiOperation(value = "自定义短信通道发送", notes = "支持同时发送多条")
    public Result<Integer> sendWithAccount(@Validated @ModelAttribute SmsWithAccountReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        Result<Integer> result = smsService.doSendWithAccount(dto);
        return result;
    }


    @RequestMapping(value = "/prop", method = RequestMethod.POST)
    public Result<String> prop() throws BaseException {
        SmsConfig smsConfig = SmsConfig.get();
        return Result.newSuccessResult(ConfigUtils.getValue("myt"));
    }
}
