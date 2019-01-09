package com.eriz.common.exception;

/**
 * <p>
 * 系统异常处理（运行时异常）
 * </p>
 * 2018年12月24日 | eriz
 */
public class ErizException extends RuntimeException {
    private static final long serialVersionUID = 6403925731816439878L;

    //自定义错误码
    private Integer code;

    //自定义构造器，只保留一个，让其必须输入错误码及内容
    public ErizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ErizException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
