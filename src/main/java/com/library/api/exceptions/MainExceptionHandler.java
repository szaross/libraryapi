package com.library.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorObject> handleBookNotFoundException(BookNotFoundException e){
        ErrorObject errorObject = ErrorObject.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorObject> handleAuthorNotFoundException(AuthorNotFoundException e){
        ErrorObject errorObject = ErrorObject.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);
    }
}
