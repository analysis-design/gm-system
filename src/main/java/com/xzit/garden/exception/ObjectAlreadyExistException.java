package com.xzit.garden.exception;

public class ObjectAlreadyExistException extends RuntimeException {
    public ObjectAlreadyExistException() {
    }

    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}
