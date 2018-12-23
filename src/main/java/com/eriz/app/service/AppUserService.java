package com.eriz.app.service;

import com.eriz.app.pojo.TokenVO;
import com.eriz.common.base.CoreService;
import com.eriz.sys.domain.UserDo;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
public interface AppUserService extends CoreService<UserDo> {
    /**
     * 申请token
     */
    TokenVO getToken(String uname, String passwd);

    /**
     * 刷新token
     */
    TokenVO refreshToken(String uname, String refreshToken);

    /**
     * 检查token是否有效：未超时、未注销
     */
    void verifyToken(String token, boolean isRefresh);

    /**
     * 注销token
     */
    void logoutToken(String token, String refreshToken);
}
