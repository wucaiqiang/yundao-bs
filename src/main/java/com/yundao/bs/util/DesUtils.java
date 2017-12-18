package com.yundao.bs.util;

import com.yundao.bs.constant.CodeConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;

/**
 * DES 加解密工具类
 *
 * @author jan
 * @create 2017-09-14 AM10:18
 **/
public class DesUtils {

    private static Log log = LogFactory.getLog(DesUtils.class);

    public static String decrypt(String content) throws BaseException {
        try {
            if (BooleanUtils.isBlank(content))
                return content;
            return com.yundao.core.utils.DesUtils.decrypt(content);
        } catch (Exception e) {
            throw new BaseException(CodeConstant.CODE_1100014);
        }
    }

}
