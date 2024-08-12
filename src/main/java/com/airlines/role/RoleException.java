package com.airlines.role;

import lombok.Data;

/**
 * @author kuldeep
 */
@Data
public class RoleException extends RuntimeException {
    private int statusCode;
    public RoleException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
