package com.sc.empreende.api.shared;

import lombok.Getter;

@Getter
public enum SegmentoAtuacao {
    TECNOLOGIA("Tecnologia"),
    COMERCIO("Comércio"),
    INDUSTRIA("Indústria"),
    SERVICOS("Serviços"),
    AGRONEGOCIO("Agronegócio");

    private final String segmento;

    SegmentoAtuacao(String segmento) {
        this.segmento = segmento;
    }
}
