package com.eriz.common.exception;

public class ErizException extends RuntimeException {
    public ErizException(String msg) {
        super(msg);
    }

    public ErizException() {
        super();
    }
}
