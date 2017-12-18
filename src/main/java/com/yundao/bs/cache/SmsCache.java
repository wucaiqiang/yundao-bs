package com.yundao.bs.cache;

import com.yundao.bs.constant.CacheKey;
import com.yundao.core.cache.redis.JedisUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 短信相关缓存操作
 *
 * @author jan
 * @create 2017-06-14 PM4:48
 **/
public class SmsCache {

    /**
     * 获取租户今天已发条数
     *
     * @param tenantId 租户id
     * @return 为空 则返回0
     */
    public static Integer getTenantSentCount(Long tenantId) {
        Object obj = JedisUtils.getObject(CacheKey.TENANT_MAX_COUNT + tenantId);
        return obj == null ? 0 : (Integer) obj;
    }

    /**
     * 在原有值基础增加sendCount条记录
     *
     * @param tenantId 租户id
     */
    public static void increTenantSentCount(Long tenantId, Integer sendCount) {
        String key = CacheKey.TENANT_MAX_COUNT + tenantId;
        JedisUtils.remove(key);
        JedisUtils.setObject(key, getTodayTimeLeft(), sendCount + getTenantSentCount(tenantId));
    }


    /**
     * 今天剩余时间
     *
     * @return 秒
     */
    private static int getTodayTimeLeft() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }
}
