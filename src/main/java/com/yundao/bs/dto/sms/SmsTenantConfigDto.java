package com.yundao.bs.dto.sms;

import java.io.Serializable;

/**
 * 短信租户配置
 *
 * @author jan
 * @create 2017-08-16 AM11:41
 **/
public class SmsTenantConfigDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
