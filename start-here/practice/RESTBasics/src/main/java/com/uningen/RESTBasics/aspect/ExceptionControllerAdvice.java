package com.uningen.RESTBasics.aspect;

import com.uningen.RESTBasics.exceptions.ErrorDetails;
import com.uningen.RESTBasics.exceptions.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("ADVICE OF THE DAY: not enough money, find a job");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
