package com.yundao.bs.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 数字枚举
 *
 * @author jan
 * @create 2017-06-17 PM1:47
 **/
public enum NumberEnum {

    ONE(1,"1"),

    ZERO(0,"0"),

    /**
     * -1,无限制
     */
    NEGATIVE_ONE(-1, "-1");

    private Integer value;
    private String name;
    private static Map<Integer, NumberEnum> enumMap = new HashMap<Integer, NumberEnum>();

    static {
        EnumSet<NumberEnum> set = EnumSet.allOf(NumberEnum.class);
        for (NumberEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    NumberEnum(Integer value, String name) {
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
    public static NumberEnum getNumberEnum(Integer value) {
        return enumMap.get(value);
    }

}
