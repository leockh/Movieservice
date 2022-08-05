package com.leo.test.movieservice.exception;

public class NotExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public NotExistsException(final String message) {
        super(message);
    }
}
