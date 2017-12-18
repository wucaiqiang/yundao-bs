package com.yundao.bs.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 是否启用枚举
 *
 * @author jan
 * @create 2017-06-17 PM1:50
 **/
public enum EnableEnum {



    /**
     * 启用
     */
    ENABLE(0, "启用"),


    /**
     * 禁用
     */
    DISABLED(1, "禁用");

    private Integer value;
    private String name;
    private static Map<Integer, EnableEnum> enumMap = new HashMap<Integer, EnableEnum>();

    static {
        EnumSet<EnableEnum> set = EnumSet.allOf(EnableEnum.class);
        for (EnableEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    EnableEnum(Integer value, String name) {
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
    public static EnableEnum getEnableEnum(Integer value) {
        return enumMap.get(value);
    }
}
