package com.xzit.garden.exception;

public class ObjectAlreadyInUse extends RuntimeException {
    public ObjectAlreadyInUse() {
    }

    public ObjectAlreadyInUse(String message) {
        super(message);
    }
}
