package com.eriz.common.ascept;

import com.eriz.common.annotation.Log;
import com.eriz.common.domain.LogDo;
import com.eriz.common.service.LogService;
import com.eriz.common.util.IPUtils;
import com.eriz.common.util.JsonUtil;
import com.eriz.common.util.ShiroUtils;
import com.eriz.common.util.WebUtil;
import com.eriz.sys.domain.UserDo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月24日 | eriz</small>
 */
@Aspect
@Component
public class LogAspect {

    @Resource
    private LogService logService;

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.eriz.common.annotation.Log)")
    public void logPointCut() {
    }

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 保存日志
     *
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDo sysLog = new LogDo();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        String params = null;
        HttpServletRequest request = WebUtil.getRequest();
        if (request != null) {
            sysLog.setMethod(request.getMethod() + " " + request.getRequestURI());
            Map<String, String[]> parameterMap = request.getParameterMap();
            params = JsonUtil.toJsonString(parameterMap);
            // 设置IP地址
            sysLog.setIp(IPUtils.getIpAddr(request));
        } else {
            sysLog.setMethod(className + "." + methodName + "()");
            Object[] args = joinPoint.getArgs();
            params = JsonUtil.toJsonString(args);
        }
        int maxLength = 4999;
        if (params.length() > maxLength) {
            params = params.substring(0, maxLength);
        }
        sysLog.setParams(params);
        // 用户名
        UserDo currUser = ShiroUtils.getSysUser();
        if (null == currUser) {
            sysLog.setUserId(-1L);
            sysLog.setUsername("");
        } else {
            sysLog.setUserId(currUser.getId());
            sysLog.setUsername(currUser.getUsername());
        }
        sysLog.setTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setGmtCreate(date);
        logService.insert(sysLog);
    }

}
