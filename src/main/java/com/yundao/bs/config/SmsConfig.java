package com.yundao.bs.config;

import com.yundao.core.utils.ConfigUtils;

/**
 * 短信配置
 *
 * @author jan
 * @create 2017-08-16 PM4:12
 **/
public class SmsConfig {

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

    /**
     * 短信签名
     */
    private String signName;

    /**
     * 每个租户每天最大发送数
     */
    private Integer tenantMaxCount;

    /**
     * 每个手机号码每天最大发送数
     */
    private Integer mobileMaxCount;

    /**
     * 验证码发送频率限制，单位秒
     */
    private Integer captchaLimitSeconds;

    SmsConfig() {
        this.blacklistMobile = ConfigUtils.getValue("sms.blacklist.mobile");
        this.blacklistTenant = ConfigUtils.getValue("sms.blacklist.tenant");
        this.onceMaxCount = Integer.valueOf(ConfigUtils.getValue("sms.onceMaxCount", "100"));
        this.signName = ConfigUtils.getValue("sms.sign.name");
        this.tenantMaxCount = Integer.valueOf(ConfigUtils.getValue("sms.tenant.max.count"));
        this.mobileMaxCount = Integer.valueOf(ConfigUtils.getValue("sms.mobile.max.count"));
        this.captchaLimitSeconds = Integer.valueOf(ConfigUtils.getValue("sms.captcha.limit.seconds"));
    }

    public static SmsConfig get() {
        return new SmsConfig();
    }

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

    public Integer getTenantMaxCount() {
        return tenantMaxCount;
    }

    public void setTenantMaxCount(Integer tenantMaxCount) {
        this.tenantMaxCount = tenantMaxCount;
    }

    public Integer getMobileMaxCount() {
        return mobileMaxCount;
    }

    public void setMobileMaxCount(Integer mobileMaxCount) {
        this.mobileMaxCount = mobileMaxCount;
    }

    public Integer getCaptchaLimitSeconds() {
        return captchaLimitSeconds;
    }

    public void setCaptchaLimitSeconds(Integer captchaLimitSeconds) {
        this.captchaLimitSeconds = captchaLimitSeconds;
    }
}
