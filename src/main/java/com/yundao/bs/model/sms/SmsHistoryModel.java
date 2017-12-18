package com.yundao.bs.model.sms;

import com.yundao.bs.model.base.BaseSmsHistory;

/**
 * 短信发送历史
 *
 * @author jan
 * @create 2017-08-17 PM2:42
 **/
public class SmsHistoryModel extends BaseSmsHistory {

    /**
     * 数据库密钥
     */
    private String dbCodeKey;

    /**
     * 字符串格式手机号
     */
    private String mobileStr;

    public String getDbCodeKey() {
        return dbCodeKey;
    }

    public void setDbCodeKey(String dbCodeKey) {
        this.dbCodeKey = dbCodeKey;
    }

    public String getMobileStr() {
        return mobileStr;
    }

    public void setMobileStr(String mobileStr) {
        this.mobileStr = mobileStr;
    }
}
