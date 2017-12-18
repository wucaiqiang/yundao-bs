package com.yundao.bs.util;

/**
 * 字符串分隔工具类
 *
 * @author jan
 * @create 2017-06-19 PM10:26
 **/
public class StringSplitUtils {

    public static String split(String str, int n) {
        int i = 0;
        int s = 0;
        while (i++ < n) {
            s = str.indexOf(",", s + 1);
            if (s == -1) {
                return str;
            }
        }
        return str.substring(0, s);
    }
}
