package com.yundao.bs.dto.sms;

import com.yundao.bs.constant.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jan
 * @create 2017-06-12 PM1:45
 **/
public class SmsReqDto {

    @NotEmpty(message = "{" + CodeConstant.CODE_1100006 + "}")
    @ApiModelProperty(value = "手机号码，多个逗号分隔")
    private String mobiles;

    @NotEmpty(message = "{" + CodeConstant.CODE_1100011 + "}")
    @ApiModelProperty(value = "模板CODE")
    private String templateCode;

    @ApiModelProperty(value = "模板参数")
    private String templateParam;

    @ApiModelProperty(value = "短信类型；1：验证码，2：通知，3：群发推广")
    private Integer smsType;

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }
}
