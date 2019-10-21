package com.eriz.sys.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: eriz 471295986@qq.com
 * @date: 2019/10/21 20:33
 */
public interface TokenService {
    String createToken();

    boolean checkToken(HttpServletRequest request);
}
