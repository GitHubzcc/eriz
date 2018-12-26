package com.eriz.common.shiro.session;

import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

/**
 * <pre>
 *  主要定义了在缓存中保存session，更新，删除，读取，获取所有的集合等操作。
 * </pre>
 * <small> 2018/12/24 | eriz</small>
 */
public class RedisSessionDAO extends EnterpriseCacheSessionDAO {

    /**
     * session 名称
     */
    private String activeSessionsCacheName;

    public RedisSessionDAO(String activeSessionsCacheName) {
        this.activeSessionsCacheName = activeSessionsCacheName;
    }

    @Override
    public String getActiveSessionsCacheName() {
        return this.activeSessionsCacheName;
    }
}
