package com.airlines.user.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserException extends RuntimeException{
    private String message;
    public UserException(String message) {
        super(message);
        this.message = message;
    }
}
