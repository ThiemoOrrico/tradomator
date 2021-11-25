package com.tradomator.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNoSuchElementException(NoSuchElementException ex){

        log.error("Ressource not found!", ex);

        ApiError apiError = new ApiError("Ressource not found!", ex.getMessage());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex){

        log.error("Given input is not processable!", ex);

        ApiError apiError = new ApiError("Given input is not processable!", ex.getMessage());

        return new ResponseEntity<>(apiError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(BadCredentialsException ex){

        log.error("Username and Password are not valid!", ex);

        ApiError apiError = new ApiError("Username and Password are not valid!", ex.getMessage());

        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(Throwable ex){

        log.error("Unknown Error!", ex);

        ApiError apiError = new ApiError("Unknown Error!", ex.getMessage());

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

