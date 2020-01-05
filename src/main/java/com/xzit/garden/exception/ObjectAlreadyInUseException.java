package com.xzit.garden.exception;

public class ObjectAlreadyInUseException extends RuntimeException {
    public ObjectAlreadyInUseException() {
    }

    public ObjectAlreadyInUseException(String message) {
        super(message);
    }
}
