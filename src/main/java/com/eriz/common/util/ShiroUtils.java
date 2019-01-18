package com.eriz.common.util;

import com.eriz.app.service.AppUserService;
import com.eriz.app.util.JWTUtil;
import com.eriz.sys.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static UserDO getSysUser() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            if (principal instanceof String) {
				String token = (String)principal;
				String userId = JWTUtil.getUserId(token);
				UserDO userDO = SpringContextHolder.getBean(AppUserService.class).selectById(userId);
				return userDO;
            } else if (principal instanceof UserDO) {
                return (UserDO) principal;
            }
        } catch (Exception ignore) {
        }
        return null;
    }

    public static Long getUserId() {
        UserDO sysUser = getSysUser();
        return sysUser == null ? null : sysUser.getId();
    }
}
