package com.eriz.app.pojo;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
public class TokenVO {
    /**
     * jwt token
     */
    private String token;

    /**
     * token 过期时间
     */
    private Long tokenExpire;

    /**
     * 刷新token
     */
    private String refleshToken;
    private Long refreshTokenExpire;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Long tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public String getRefleshToken() {
        return refleshToken;
    }

    public void setRefleshToken(String refleshToken) {
        this.refleshToken = refleshToken;
    }

    public Long getRefreshTokenExpire() {
        return refreshTokenExpire;
    }

    public void setRefreshTokenExpire(Long refreshTokenExpire) {
        this.refreshTokenExpire = refreshTokenExpire;
    }
}
