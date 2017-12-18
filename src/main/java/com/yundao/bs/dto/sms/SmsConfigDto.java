package com.yundao.bs.dto.sms;

import java.io.Serializable;

/**
 * 短信配置
 *
 * @author jan
 * @create 2017-06-17 PM2:17
 **/
public class SmsConfigDto implements Serializable {

    /**
     * 公共短信配置
     */
    private SmsCommonConfigDto commonConfig;

    /**
     * 租户短信配置
     */
    private SmsTenantConfigDto tenantConfig;

    public SmsCommonConfigDto getCommonConfig() {
        return commonConfig;
    }

    public void setCommonConfig(SmsCommonConfigDto commonConfig) {
        this.commonConfig = commonConfig;
    }

    public SmsTenantConfigDto getTenantConfig() {
        return tenantConfig;
    }

    public void setTenantConfig(SmsTenantConfigDto tenantConfig) {
        this.tenantConfig = tenantConfig;
    }
}
