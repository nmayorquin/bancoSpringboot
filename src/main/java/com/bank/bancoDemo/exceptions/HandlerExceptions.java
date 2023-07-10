package com.bank.bancoDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class HandlerExceptions {


    //not found
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerNotfoundException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setTransactionId(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    //not save
    @ExceptionHandler(NotSaveException.class)
    public ResponseEntity<ErrorResponse> handlerNotSaveException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setTransactionId(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

    }

}