package com.sc.empreende.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sc.empreende.api.dtos.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmpreendimentoNotFoundById.class)
    public ResponseEntity<ErrorMessage> handleEmpreendimentoNotFoundById(EmpreendimentoNotFoundById ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }
}
