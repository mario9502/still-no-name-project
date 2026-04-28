package com.example.mario.exception;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {

    public HttpStatus statusCode;

    public String message;

    public String timestamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(
            HttpStatus statusCode,
            String message,
            String timestamp
    ) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }
}
