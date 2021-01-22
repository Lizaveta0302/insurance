package com.lizoon.insurance.exception;

public class NotFoundException extends AbstractRuntimeExceptionWithFieldName {

    public NotFoundException(String message, String fieldName) {
        super(message, fieldName);
    }
}