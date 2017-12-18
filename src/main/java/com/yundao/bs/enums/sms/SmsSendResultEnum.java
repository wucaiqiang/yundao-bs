package com.yundao.bs.enums.sms;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送结果枚举
 *
 * @author jan
 * @create 2017-06-19 AM9:08
 **/
public enum SmsSendResultEnum {


    /**
     * 成功
     */
    SUCCESS(1, "成功"),


    /**
     * 失败
     */
    FAILURE(0, "失败");

    private Integer value;
    private String name;
    private static Map<Integer, SmsSendResultEnum> enumMap = new HashMap<Integer, SmsSendResultEnum>();

    static {
        EnumSet<SmsSendResultEnum> set = EnumSet.allOf(SmsSendResultEnum.class);
        for (SmsSendResultEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    SmsSendResultEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     *
     * @param value
     * @return
     */
    public static SmsSendResultEnum getSmsSendResultEnum(Integer value) {
        return enumMap.get(value);
    }
}
