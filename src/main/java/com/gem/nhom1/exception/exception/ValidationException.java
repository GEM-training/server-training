package com.gem.nhom1.exception.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by vanhop on 1/28/16.
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

}
