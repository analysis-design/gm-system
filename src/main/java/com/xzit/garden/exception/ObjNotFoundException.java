package com.xzit.garden.exception;

/**
 * 对象未找到异常
 */
public class ObjNotFoundException extends RuntimeException {
    public ObjNotFoundException(String message) {
        super(message);
    }
}
