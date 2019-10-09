package com.giang.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerCustom {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object handler(HttpServletRequest req, EntityNotFoundException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Object handler(HttpServletRequest req, EntityExistsException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
