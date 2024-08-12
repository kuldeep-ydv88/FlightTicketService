package com.airlines.exceptions;

import com.airlines.role.RoleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author kuldeep
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoleException.class)
    public ResponseEntity<?> handleException(RoleException exception){
        return ResponseEntity.status(exception.getStatusCode())
                .body(exception.getMessage());
    }

}
