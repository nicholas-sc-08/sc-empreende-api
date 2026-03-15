package com.sc.empreende.api.dtos.Response;

import java.util.UUID;

import com.sc.empreende.api.shared.SegmentoAtuacao;
import com.sc.empreende.api.shared.StatusEmpreendimento;

public record EmpreendimentoResponseDTO(
    UUID id,
    String nomeEmpreendimento,
    String nomeResponsavel,
    String municipio,
    SegmentoAtuacao segmento,
    String email,
    StatusEmpreendimento statusEmpreendimento
) {}
