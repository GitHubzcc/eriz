package com.eriz.sys.sysCore;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
@Component
@ConfigurationProperties(prefix = "ifast.shiro")
public class ShiroProperties {
    private String sessionKeyPrefix = "ifast:session";
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
