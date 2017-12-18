package com.yundao.bs.dto.sms;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云短信结果
 *
 * @author jan
 * @create 2017-08-16 PM5:11
 **/
public class AliyunSmsResult {

    static Map<String, String> params;

    public static Boolean isSuccess(String code) {
        return "OK".equals(code);
    }

    public static String getResult(String code) {
        if (params == null) {
            initialData();
        }
        return params.get(code);
    }

    private static void initialData() {
        params = new HashMap<>();
        params.put("OK", "请求成功");
        params.put("isp.RAM_PERMISSION_DENY", "RAM权限DENY");
        params.put("isv.OUT_OF_SERVICE", "业务停机");
        params.put("isv.PRODUCT_UN_SUBSCRIPT", "未开通云通信产品的阿里云客户");
        params.put("isv.PRODUCT_UNSUBSCRIBE", "产品未开通");
        params.put("isv.ACCOUNT_NOT_EXISTS", "账户不存在");
        params.put("isv.ACCOUNT_ABNORMAL", "账户异常");
        params.put("isv.SMS_TEMPLATE_ILLEGAL", "短信模板不合法");
        params.put("isv.SMS_SIGNATURE_ILLEGAL", "短信签名不合法");
        params.put("isv.INVALID_PARAMETERS", "参数异常");
        params.put("isp.SYSTEM_ERROR", "系统错误");
        params.put("isv.MOBILE_NUMBER_ILLEGAL", "非法手机号");
        params.put("isv.MOBILE_COUNT_OVER_LIMIT", "手机号码数量超过限制");
        params.put("isv.TEMPLATE_MISSING_PARAMETERS", "模板缺少变量");
        /**
         * 注意：
         * 短信验证码 ：使用同一个签名，对同一个手机号码发送短信验证码，1条/分钟，5条/小时，10条/天。一个手机号码通过阿里云短信服务平台只  能收到40条/天。
         短信通知： 使用同一个签名和同一个短信模板ID，对同一个手机号码发送短信通知，支持50条/日（指自然日）
         出发以上条件，阿里云将返回 isv.BUSINESS_LIMIT_CONTROL
         */
        params.put("isv.BUSINESS_LIMIT_CONTROL", "业务限流");
        params.put("isv.INVALID_JSON_PARAM", "JSON参数不合法，只接受字符串值");
        params.put("isv.BLACK_KEY_CONTROL_LIMIT", "黑名单管控");
        params.put("isv.PARAM_LENGTH_LIMIT", "参数超出长度限制");
        params.put("isv.PARAM_NOT_SUPPORT_URL", "不支持URL");
        params.put("isv.AMOUNT_NOT_ENOUGH", "账户余额不足");
    }

}
