package com.airlines.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidCredentialsException extends RuntimeException {
    private int statusCode;
    public InvalidCredentialsException(String message, Throwable th, int statusCode) {
        super(message, th);
        this.statusCode = statusCode;
    }

    public InvalidCredentialsException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
