package com.yundao.bs.constant;

/**
 * msc编码
 *
 * @author jan
 * @create 2017-06-19 AM9:18
 **/
public interface CodeConstant {

    int BASE = 1100000;
    /**
     * 租户短信功能被禁用
     */
    int CODE_1100000 = BASE;

    /**
     * 租户今天发送已达上限
     */
    int CODE_1100001 = BASE + 1;

    /**
     * 过滤掉格式错误号码后，需要发送的号码为空
     */
    int CODE_1100002 = BASE + 2;

    /**
     * 过滤掉黑名单后，需要发送的号码为空
     */
    int CODE_1100003 = BASE + 3;

    /**
     * 该租户没有任何配置信息
     */
    int CODE_1100004 = BASE + 4;

    /**
     * 租户id不能为空
     */
    int CODE_1100005 = BASE + 5;

    /**
     * 手机号码不能为空
     */
    int CODE_1100006 = BASE + 6;

    /**
     * 发送内容不能为空
     */
    int CODE_1100007 = BASE + 7;

    /**
     * 短信服务类别(serviceType)不能为空
     */
    int CODE_1100008 = BASE + 8;

    /**
     * 业务对象有误
     */
    int CODE_1100009 = BASE + 9;

    /**
     * 无效的身份标识
     */
    int CODE_1100010 = BASE + 10;

    /**
     * 模板CODE不能为空
     */
    int CODE_1100011 = BASE + 11;

    /**
     * 短信发送失败
     */
    int CODE_1100012 = BASE + 12;

    /**
     * 没有找到租户的短信通道信息
     */
    int CODE_1100013 = BASE + 13;

    /**
     * accesskey解密失败
     */
    int CODE_1100014 = BASE + 14;
}
