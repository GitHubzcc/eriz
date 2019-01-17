package com.eriz.app.service.impl;

import com.eriz.app.config.JWTConfigProperties;
import com.eriz.app.pojo.vo.TokenVO;
import com.eriz.app.service.AppUserService;
import com.eriz.app.util.JWTUtil;
import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.enumType.EnumErrorCode;
import com.eriz.common.exception.ErizException;
import com.eriz.common.util.MD5Utils;
import com.eriz.common.util.SpringContextHolder;
import com.eriz.sys.dao.UserDao;
import com.eriz.sys.domain.UserDo;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
@Service
public class AppUserServiceImpl extends CoreServiceImpl<UserDao, UserDo> implements AppUserService {
    /**
     * Holder for lazy-init
     */
    private static class Holder {
        static final JWTConfigProperties JWT_CONFIG_PROPERTIES = SpringContextHolder.getBean(JWTConfigProperties.class);
        static final Cache LOGOUT_TOKENS = null;
//		static final Cache logoutTokens = CacheConfiguration.dynaConfigCache(jwtConfig.getExpireTokenKeyPrefix(), jwtConfig
//                .getRefreshTokenExpire());
    }

    @Override
    public TokenVO getToken(String username, String passwd) {
        UserDo user = findOneByKv("username", username);
        if (null == user || !user.getPassword().equals(MD5Utils.encrypt(username, passwd))) {
            throw new ErizException(EnumErrorCode.apiAuthorizationLoginFailed.getCodeStr());
        }
        return createToken(user);
    }

    @Override
    public void verifyToken(String token, boolean isRefreshToken) {
        ensureAvailable(token, isRefreshToken);
    }

    @Override
    public TokenVO refreshToken(String uname, String refreshToken) {

        ensureAvailable(refreshToken, true);

        UserDo user = findOneByKv("username", uname);
        if (user == null) {
            throw new ErizException(EnumErrorCode.apiAuthorizationInvalid.getCodeStr());
        }

        return createToken(user);
    }

    @Override
    public void logoutToken(String token, String refreshToken) {
        Holder.LOGOUT_TOKENS.putIfAbsent(token, null);
        Holder.LOGOUT_TOKENS.putIfAbsent(refreshToken, null);
    }

    private TokenVO createToken(UserDo user) {
        TokenVO vo = new TokenVO();
        String token = JWTUtil.sign(user.getId() + "", user.getUsername() + user.getPassword(), Holder.JWT_CONFIG_PROPERTIES.getExpireTime());
        String refreshToken = JWTUtil.sign(user.getId() + "", user.getUsername() + user.getPassword(), Holder.JWT_CONFIG_PROPERTIES.getExpireTime(), true);
        vo.setToken(token);
        vo.setRefleshToken(refreshToken);
        vo.setTokenExpire(Holder.JWT_CONFIG_PROPERTIES.getExpireTime());
        vo.setRefreshTokenExpire(Holder.JWT_CONFIG_PROPERTIES.getRefreshTokenExpire());
        return vo;
    }

    private void ensureAvailable(String token, boolean isRefreshToken) {
        if (StringUtils.isBlank(token)) {
            throw new ErizException(EnumErrorCode.apiAuthorizationInvalid.getCodeStr());
        }
        String userId = JWTUtil.getUserId(token);
        if (StringUtils.isBlank(userId)) {
            throw new ErizException(EnumErrorCode.apiAuthorizationInvalid.getCodeStr());
        }
        if (Holder.LOGOUT_TOKENS.get(token) != null) {
            throw new ErizException(EnumErrorCode.apiAuthorizationLoggedout.getCodeStr());
        }

        UserDo userDO = selectById(userId);

        if (userDO == null) {
            throw new ErizException(EnumErrorCode.apiAuthorizationInvalid.getCodeStr());
        }

        if (isRefreshToken) {
            JWTUtil.verify(token, userDO.getId() + "", userDO.getUsername() + userDO.getPassword(), true);
        } else {
            JWTUtil.verify(token, userDO.getId() + "", userDO.getUsername() + userDO.getPassword());
        }
    }
}
