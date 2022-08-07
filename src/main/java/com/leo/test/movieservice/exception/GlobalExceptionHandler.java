package com.leo.test.movieservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.leo.test.movieservice.exception.NotExistsException;

import lombok.extern.slf4j.Slf4j;

import com.leo.test.movieservice.exception.AlreadyExistsException;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        log.info("IllegalArgumentException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleUserAlreadyExistsException(HttpServletRequest request, AlreadyExistsException e) {
        log.info("UserAlreadyExistsException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    
    @ExceptionHandler(NotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNonExistingUserException(HttpServletRequest request, NotExistsException e) {
        log.info("NoUserExistsException occured: URL="+request.getRequestURL());
        return e.getLocalizedMessage();
    }
    

}