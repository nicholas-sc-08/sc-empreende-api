package com.sc.empreende.api.exceptions;

public class EmpreendimentoNotFoundById extends RuntimeException {
    public EmpreendimentoNotFoundById(String message) {
        super(message);
    }
}
