package com.sc.empreende.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sc.empreende.api.dtos.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmpreendimentoNotFoundById.class)
    public ResponseEntity<ErrorMessage> handleEmpreendimentoNotFoundById(EmpreendimentoNotFoundById ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(EmpreendimentoEmailAlreadyExists.class)
    public ResponseEntity<ErrorMessage> handleEmpreendimentoEmailAlreadyExists(EmpreendimentoEmailAlreadyExists ex) {
        return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        String message = "Erro na leitura do JSON. Verifique se os valores de campos como 'segmento' estão corretos.";
        return ResponseEntity.status(400).body(new ErrorMessage(message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Pega a primeira mensagem de erro definida nas anotações do DTO
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(400).body(new ErrorMessage(message));
    }
}
