package com.eriz.common.exception;

/**
 * <p>
 *      系统异常处理（运行时异常）
 * </p>
 * 2018年12月24日 | eriz
 */
public class ErizException extends RuntimeException {
    private static final long serialVersionUID = 6403925731816439878L;

    public ErizException() {
        super();
    }

    public ErizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ErizException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErizException(String message) {
        super(message);
    }

    public ErizException(Throwable cause) {
        super(cause);
    }
}
