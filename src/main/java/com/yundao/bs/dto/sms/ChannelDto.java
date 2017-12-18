package com.yundao.bs.dto.sms;

import java.io.Serializable;

/**
 * 短信通道
 *
 * @author jan
 * @create 2017-06-12 PM1:45
 **/
public class ChannelDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通道id
     */
    private Long id;

    /**
     * 服务商id
     */
    private Long providerId;

    /**
     * 服务商code
     */
    private String providerCode;


    /**
     * 通道账号
     */
    private String account;

    /**
     * 通道密码
     */
    private String password;

    /**
     * 通道服务类别
     */
    private Integer ServiceType;

    /**
     * 主机地址
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 通道每次最多能发短信数量
     */
    private Integer onceMaxCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getServiceType() {
        return ServiceType;
    }

    public void setServiceType(Integer serviceType) {
        ServiceType = serviceType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getOnceMaxCount() {
        return onceMaxCount;
    }

    public void setOnceMaxCount(Integer onceMaxCount) {
        this.onceMaxCount = onceMaxCount;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
}
