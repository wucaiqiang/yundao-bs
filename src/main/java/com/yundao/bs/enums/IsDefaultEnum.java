package com.yundao.bs.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信服务类别美剧
 *
 * @author jan
 * @create 2017-06-15 PM7:35
 **/
public enum IsDefaultEnum {


    /**
     * yes
     */
    NO(0, "否"),


    /**
     * no
     */
    YES(1, "是");

    private Integer value;
    private String name;
    private static Map<Integer, IsDefaultEnum> enumMap = new HashMap<Integer, IsDefaultEnum>();

    static {
        EnumSet<IsDefaultEnum> set = EnumSet.allOf(IsDefaultEnum.class);
        for (IsDefaultEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    IsDefaultEnum(Integer value, String name) {
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
    public static IsDefaultEnum getIsDefaultEnum(Integer value) {
        return enumMap.get(value);
    }
}
