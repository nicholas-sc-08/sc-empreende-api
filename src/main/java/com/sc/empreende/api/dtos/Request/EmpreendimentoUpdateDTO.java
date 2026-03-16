package com.sc.empreende.api.dtos.Request;

import com.sc.empreende.api.shared.SegmentoAtuacao;

public record EmpreendimentoUpdateDTO (
    String nomeEmpreendimento,
    String nomeResponsavel,
    String municipio,
    SegmentoAtuacao segmento,
    String email
) {}
