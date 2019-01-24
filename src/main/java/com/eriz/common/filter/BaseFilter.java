package com.eriz.common.filter;

import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统过滤器
 *
 * @author eriz
 * @date 2019年1月24日
 */
public class BaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 允许跨域 * 为全部
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许访问方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 允许访问时间单位秒，在设定时间内不能访问多次
        response.setHeader("Access-Control-Max-Age", "3600");
        // 允许请求head字段内容，多个用逗号隔开，如下
        response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
        // 允许访问凭证
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //客户端请求方式为OPTIONS 时会先发送请求到服务器探测是否允许访问，如果允许再继续访问get/post请求，该方法处理允许OPTIONS访问方式
        String method = "OPTIONS";
        if (method.equals(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().write("OPTIONS returns OK");
            return;
        }
        // 传递业务请求处理
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
