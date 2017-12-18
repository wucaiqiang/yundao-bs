package com.yundao.bs.dto.sms;

/**
 * @author jan
 * @create 2017-09-15 AM8:54
 **/
public class SmsSendResult {

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 本批次是否判定为发送成功
     */
    private Boolean success;

    /**
     * 编码描述
     */
    private String message;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
