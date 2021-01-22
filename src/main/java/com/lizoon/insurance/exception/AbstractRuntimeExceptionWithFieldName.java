package com.lizoon.insurance.exception;

import lombok.Getter;

@Getter
public abstract class AbstractRuntimeExceptionWithFieldName extends RuntimeException {

    private String fieldName;

    public AbstractRuntimeExceptionWithFieldName(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
