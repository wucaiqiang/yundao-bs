package com.yundao.bs.constant;

/**
 * 缓存键
 *
 * @author jan
 * @create 2017-06-14 PM4:35
 **/
public interface CacheKey {

    String PREFIX = "bs:com.yunndao.bs.";

    /**
     * 租户每天最大发送数
     */
    String TENANT_MAX_COUNT = PREFIX + "tenant_max_count_";
}
