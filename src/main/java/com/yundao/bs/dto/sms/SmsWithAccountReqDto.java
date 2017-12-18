package com.yundao.bs.dto.sms;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-09-13 PM7:38
 **/
public class SmsWithAccountReqDto extends SmsReqDto {

    @ApiModelProperty(value = "accessKeyId")
    private String accessKeyId;

    @ApiModelProperty(value = "accessKeySecret")
    private String accessKeySecret;

    @ApiModelProperty(value = "签名")
    private String sign;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
