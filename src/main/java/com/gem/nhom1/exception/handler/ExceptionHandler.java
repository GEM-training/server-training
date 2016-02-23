package com.gem.nhom1.exception.handler;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.util.Constant;
import org.apache.log4j.Logger;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vanhop on 1/28/16.
 */
@ControllerAdvice
public class ExceptionHandler {

    final static Logger logger = Logger.getLogger(ExceptionHandler.class);

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({SQLException.class,DataAccessException.class})
    public @ResponseBody ResponseDTO databaseError(HttpServletRequest req,Exception ex) {
        // Nothing to do.  Returns the logical view name of an error page, passed to
        // the view-resolver(s) in usual way.
        // Note that the exception is _not_ available to this view (it is not added to
        // the model) but see "Extending ExceptionHandlerExceptionResolver" below.
        logger.error(req.getRequestURI(),ex);
        return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, ex.getMessage(),null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public @ResponseBody ResponseDTO validException(HttpServletRequest req, ValidationException exception) {
        return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, exception.getMessage(), null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public @ResponseBody ResponseDTO handleError(HttpServletRequest req, Exception exception) {
        return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, exception.getMessage() ,null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(GenericJDBCException.class)
    public @ResponseBody ResponseDTO handleErrorJDBC(HttpServletRequest req, Exception exception) {
        logger.error(req.getRequestURI(),exception);
        return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, exception.getMessage() ,null);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(IOException.class)
    public @ResponseBody ResponseDTO handleIOException(HttpServletRequest req, Exception exception){
        logger.error(req.getRequestURI(),exception);
        return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, exception.getMessage() ,null);
    }

}
