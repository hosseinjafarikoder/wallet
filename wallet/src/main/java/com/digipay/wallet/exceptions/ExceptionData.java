package com.digipay.wallet.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ExceptionData {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime stamp;

    public ExceptionData(String message, HttpStatus status, ZonedDateTime stamp) {
        this.message = message;
        this.status = status;
        this.stamp = stamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getStamp() {
        return stamp;
    }
}
