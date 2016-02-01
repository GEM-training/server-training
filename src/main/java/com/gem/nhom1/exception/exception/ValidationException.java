package com.gem.nhom1.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by vanhop on 1/28/16.
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

}
