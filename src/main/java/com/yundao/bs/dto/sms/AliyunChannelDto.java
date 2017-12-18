package com.yundao.bs.dto.sms;

/**
 * 阿里云短信通道
 *
 * @author jan
 * @create 2017-08-16 PM2:11
 **/
public class AliyunChannelDto {

    private String accessKeyId;

    private String accessKeySecret;

    /**
     * 签名
     */
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
