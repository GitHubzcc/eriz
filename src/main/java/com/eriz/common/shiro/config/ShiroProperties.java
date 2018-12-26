package com.eriz.common.shiro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/12/24 | eriz</small>
 */
@Component
@ConfigurationProperties(prefix = "eriz.shiro")
public class ShiroProperties {
    private String sessionKeyPrefix = "eriz:session";
    private String jsessionidKey = "SESSION";

    public String getSessionKeyPrefix() {
        return sessionKeyPrefix;
    }

    public void setSessionKeyPrefix(String sessionKeyPrefix) {
        this.sessionKeyPrefix = sessionKeyPrefix;
    }

    public String getJsessionidKey() {
        return jsessionidKey;
    }

    public void setJsessionidKey(String jsessionidKey) {
        this.jsessionidKey = jsessionidKey;
    }
}
