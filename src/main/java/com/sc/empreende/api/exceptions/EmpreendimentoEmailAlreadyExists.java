package com.sc.empreende.api.exceptions;

public class EmpreendimentoEmailAlreadyExists extends RuntimeException {
    public EmpreendimentoEmailAlreadyExists(String message) {
        super(message);
    }
}
