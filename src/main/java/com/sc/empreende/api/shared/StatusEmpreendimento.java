package com.sc.empreende.api.shared;

import lombok.Getter;

@Getter
public enum StatusEmpreendimento {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String status;

    StatusEmpreendimento(String status) {
        this.status = status;
    }
}
