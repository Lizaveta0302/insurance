package com.lizoon.insurance.web.handler;

import com.lizoon.insurance.dto.SimpleResponse;
import com.lizoon.insurance.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionInfoHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SimpleResponse> handleNotFound(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(SimpleResponse
                        .builder()
                        .withPropertyName(e.getFieldName())
                        .withPropertyValue(e.getMessage())
                        .build());
    }
}
