package com.eriz.common.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * Web辅助类.
 * <p>
 * 2018年12月11日 eriz
 */
public final class WebUtil {

    /**
     * 获取 HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取 HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取request中的attribute属性值.
     */
    public static Object getAttribute(String name) {
        return getRequest().getAttribute(name);
    }

    /**
     * 获取web项目http路径.
     *
     * @return eg：http://localhost:8080/XXproj/
     */
    private static String getContextPath() {
        return getRequest().getContextPath();
    }

    /**
     * 从request中获取Parameter参数,并重新设置回到Request属性当中..
     *
     * @param name 参数名字.
     * @return parameterValue 参数值
     */
    public static String getParameter(String name) {
        String parameterValue = getRequest().getParameter(name);
        getRequest().setAttribute(name, parameterValue);
        return parameterValue;
    }

    /**
     * 从request中获取所有参数的名字.
     *
     * @return 参数名称列表
     */
    public static List<String> getParameterNames() {
        List<String> names = new ArrayList<String>();
        Enumeration<String> en = getRequest().getParameterNames();
        while (en.hasMoreElements()) {
            names.add(en.nextElement());
        }
        return names;
    }

    /**
     * 从request中获取所有的参数键值对，并重新设置回到Request属性当中.
     */
    public static Map<String, String[]> getParameters() {
        Map<String, String[]> map = getRequest().getParameterMap();
        Map<String, String[]> newMap = new HashMap<String, String[]>();

        if (map != null && !map.isEmpty()) {
            for (Entry<String, String[]> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!"_".equals(key)) {
                    newMap.put(entry.getKey(), entry.getValue());
                    WebUtil.setAttribute(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        return newMap;
    }

    /**
     * 从request中获取所有的参数键值对，并重新设置回到Request属性当中.
     */
    public static Map<String, Object> getAllParameters() {
        Map<String, String[]> map = getRequest().getParameterMap();
        Map<String, Object> newMap = new HashMap<String, Object>();

        if (map != null && !map.isEmpty()) {
            for (Entry<String, String[]> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!"_".equals(key)) {
                    newMap.put(entry.getKey(), entry.getValue()[0]);
                    WebUtil.setAttribute(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        return newMap;
    }

    /**
     * 把请求参数封装成Map
     */
    public static Map<String, Object> getParameterMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<String> e = getRequest().getParameterNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            map.put(s, getRequest().getParameter(s));
        }
        return map;
    }

    /**
     * 将request中经过编码的url参数转换成 utf-8类型(特别是中文参数)，并重新设置回到Request属性当中.
     */
    public static String getParameterToUTF8(String name) {
        String para = getParameter(name);
        try {
            if (StringUtils.isNotBlank(para)) {
                String parameterValue = URLDecoder.decode(para, "UTF-8");
                getRequest().setAttribute(name, parameterValue);
                return parameterValue;
            }
        } catch (UnsupportedEncodingException e) {
            para = null;
            e.printStackTrace();
        }
        return para;
    }

    /**
     * 从request中获取参数的值列表.
     */
    public static String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    /**
     * 获取web项目物理绝对路径
     *
     * @return eg：C:/webapp/deploy/
     */
    public static String getRealPath() {
        return getServletContext().getRealPath(".");
    }

    /**
     * 获取hmi主页路径.
     *
     * @return http://${pageContext.request.serverName}:${pageContext.request.serverPort}${ctx}
     */
    public static String getServerUrl() {
        return "http://" + getRequest().getServerName() + ":" + getRequest().getServerPort() + getContextPath();
    }

    /**
     * 获取ServletContext.
     */
    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }

    /**
     * 获取当前web请求的相对路径.
     */
    public static String getServletPath() {
        return getRequest().getServletPath();
    }

    /**
     * 获取ServletContext属性值.
     */
    public static Object getServletContextAttribute(String name) {
        return getServletContext().getAttribute(name);
    }

    /**
     * 获取HttpSession.
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static Object getSession(String name) {
        return getSession().getAttribute(name);
    }

    /**
     * 将相对路径转换成web绝对路径
     *
     * @param servletPath 首字符不包含 斜杠
     */
    public static String getWebPath(String servletPath) {
        return getContextPath() + servletPath;
    }

    public static void removeServletContextAttribute(String name) {
        getServletContext().removeAttribute(name);
    }

    public static void removeSessionAttribute(String name) {
        getSession().removeAttribute(name);
    }

    /**
     * 设置request的属性值.
     *
     * @param name  属性名称
     * @param value 属性值
     */
    public static void setAttribute(String name, Object value) {
        getRequest().setAttribute(name, value);
    }

    /**
     * 设置ServletContext属性值(应用程序全局使用).
     *
     * @param name  属性名字
     * @param value 属性值
     */
    public static void setServletContextAttribute(String name, Object value) {
        getServletContext().setAttribute(name, value);
    }

    /**
     * 设置session属性值.
     *
     * @param name  属性名字
     * @param value 属性值
     */
    public static void setSession(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public static boolean isAjax(){
        HttpServletRequest httpRequest = getRequest();
        String requestHeader = httpRequest.getHeader("X-Requested-With");
        return  requestHeader != null && "XMLHttpRequest".equals(requestHeader);
    }

}
