package com.yundao.bs.dto.sms;

import java.io.Serializable;

/**
 * 公共短信配置
 *
 * @author jan
 * @create 2017-08-16 AM11:30
 **/
public class SmsCommonConfigDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户黑名单
     */
    private String blacklistMobile;

    /**
     * 手机号码黑名单
     */
    private String blacklistTenant;

    /**
     * 每次发送最大条数
     */
    private Integer onceMaxCount;

    public String getBlacklistMobile() {
        return blacklistMobile;
    }

    public void setBlacklistMobile(String blacklistMobile) {
        this.blacklistMobile = blacklistMobile;
    }

    public String getBlacklistTenant() {
        return blacklistTenant;
    }

    public void setBlacklistTenant(String blacklistTenant) {
        this.blacklistTenant = blacklistTenant;
    }

    public Integer getOnceMaxCount() {
        return onceMaxCount;
    }

    public void setOnceMaxCount(Integer onceMaxCount) {
        this.onceMaxCount = onceMaxCount;
    }
}
