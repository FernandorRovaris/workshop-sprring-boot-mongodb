package com.spring.spring.resources.exceptions;

import com.spring.spring.services.exceptions.ObjectNotFoundException;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResoucerExceptionHandler {

    public RequestEntity<StandardError> objectNotFoud(ObjectNotFoundException e, Httpserverlet){

    }
    
}
