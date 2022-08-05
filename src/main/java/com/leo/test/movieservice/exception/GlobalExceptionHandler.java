package com.leo.test.movieservice.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.leo.test.movieservice.exception.NotExistsException;
import com.leo.test.movieservice.exception.AlreadyExistsException;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	protected static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        LOGGER.info("IllegalArgumentException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleUserAlreadyExistsException(HttpServletRequest request, AlreadyExistsException e) {
        LOGGER.info("UserAlreadyExistsException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    
    @ExceptionHandler(NotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNonExistingUserException(HttpServletRequest request, NotExistsException e) {
        LOGGER.info("NoUserExistsException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    

}