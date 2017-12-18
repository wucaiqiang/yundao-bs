package com.yundao.bs.dto.sms;

/**
 * 短信批次dto
 *
 * @author jan
 * @create 2017-06-19 AM8:23
 **/
public class SmsBatchDto {


    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 此批次需要发送的手机号码
     */
    private String mobiles;

    /**
     * 结果状态码
     */
    private String resultCode;

    /**
     * 结果状态码描述
     */
    private String message;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
