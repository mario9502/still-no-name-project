package com.example.mario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = EntityNotFound.class)
    public ResponseEntity<CustomErrorResponse> throwNotFoundException(RuntimeException exception) {

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                Instant.now().toString()
        );

        return new ResponseEntity<>(customErrorResponse, customErrorResponse.statusCode);
    }

    @ExceptionHandler(exception = RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> throwRuntimeException(RuntimeException exception) {

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Instant.now().toString()
        );

        return new ResponseEntity<>(customErrorResponse, customErrorResponse.statusCode);
    }
}
