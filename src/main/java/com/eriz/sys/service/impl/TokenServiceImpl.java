package com.eriz.sys.service.impl;

import com.eriz.common.exception.ErizException;
import com.eriz.common.redis.cache.RedisUtil;
import com.eriz.sys.service.TokenService;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: eriz 471295986@qq.com
 * @date: 2019/10/21 20:34
 */
@Service
public class TokenServiceImpl implements TokenService {

    public static String TOKEN_NAME = "TOKEN_NAME";

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String createToken() {
        //获取token
        String token = "";
        //放入redis
        redisUtil.set(token,token);
        return null;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isNullOrEmpty(token)) {
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isNullOrEmpty(token)) {
                throw new ErizException("token 不存在");
            }
        }

        if (!redisUtil.hasKey(token)) {
            throw new ErizException("token 不存在");
        }
        redisUtil.del(token);
        return true;
    }
}
