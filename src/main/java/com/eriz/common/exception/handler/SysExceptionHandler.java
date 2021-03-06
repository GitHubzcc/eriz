package com.eriz.common.exception.handler;

import com.eriz.common.enumType.EnumErrorCode;
import com.eriz.common.exception.ErizException;
import com.eriz.common.util.Result;
import com.eriz.common.util.WebUtil;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 */
@ControllerAdvice
public class SysExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    /* 未知错误 */
    public final static String ERROR_DEFAULT_PAGE = "error/error";

    /* 未授权 */
    public final static String ERROR_AUTH = "error/error2";

    /**
     * 未知错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        if (!WebUtil.isAjax()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName(ERROR_DEFAULT_PAGE);
            return mv;
        } else {
            log.error(e.getMessage());
            return Result.build(EnumErrorCode.unknowFail.getCode(), EnumErrorCode.unknowFail.getMsg());
        }
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> illegalArgumentException(IllegalArgumentException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        return Result.build(EnumErrorCode.illegalArgument.getCode(), e.getMessage());
    }

    private Result<String> getStringResult(String message) {
        try {
            int code = Integer.parseInt(message);
            return Result.build(code, EnumErrorCode.getMsgByCode(code));
        } catch (NumberFormatException e1) {
            log.warn("错误码使用错误，异常内容请抛出EnumErrorCode类的枚举值");
            e1.printStackTrace();
            return Result.build(EnumErrorCode.unknowFail.getCode(), EnumErrorCode.unknowFail.getMsg());
        }
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(ErizException.class)
    public Object handleSysException(ErizException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        if (!WebUtil.isAjax()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName(ERROR_DEFAULT_PAGE);
            return mv;
        } else {
            return getStringResult(e.getMessage());
        }
    }

    /**
     * 插入数据库 数据已存在异常
     *
     * @param e
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        return Result.build(EnumErrorCode.duplicateKeyExist.getCode(), EnumErrorCode.duplicateKeyExist.getMsg());
    }

    /**
     * 页面不存在
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<String> noHandlerFoundException(NoHandlerFoundException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        return Result.build(EnumErrorCode.pageNotFound.getCode(), EnumErrorCode.pageNotFound.getMsg());
    }

    /**
     * shiro
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public Result handleAuthorizationException(ShiroException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        if (e instanceof IncorrectCredentialsException) {
            return Result.build(EnumErrorCode.apiAuthorizationFailed.getCode(), EnumErrorCode.apiAuthorizationFailed.getMsg());
        } else if (e instanceof ExpiredCredentialsException) {
            return Result.build(EnumErrorCode.apiAuthorizationExpired.getCode(), EnumErrorCode.apiAuthorizationExpired.getMsg());
        }
        return Result.build(EnumErrorCode.notAuthorization.getCode(), EnumErrorCode.notAuthorization.getMsg());
    }

    @ExceptionHandler(UnknownSessionException.class)
    public String unknownSessionException(UnknownSessionException e) {
        log.error("==========发生了异常");
        log.error("==========异常类型：" + e.getClass().getSimpleName());
        log.error("==========异常描述：" + e.getMessage());
        log.error("==========异常原因：" + e.getCause());
        return ERROR_DEFAULT_PAGE;
    }
}
