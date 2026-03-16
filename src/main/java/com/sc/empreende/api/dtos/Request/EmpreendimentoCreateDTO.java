package com.sc.empreende.api.dtos.Request;

import com.sc.empreende.api.shared.SegmentoAtuacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpreendimentoCreateDTO(
    @NotBlank(message = "Digite um nome de empreendimento válido!")
    String nomeEmpreendimento,

    @NotBlank(message = "Digite um nome de responsável pelo empreendimento que seja válido!")
    String nomeResponsavel,

    @NotBlank(message = "Digite um nome de município válido!")
    String municipio,

    @NotNull(message = "Os segmentos válidos são: **TECNOLOGIA**, **COMERCIO**, **INDUSTRIA**, **SERVICOS** ou **AGRONEGOCIO**")
    SegmentoAtuacao segmento,

    @Email(message = "O formato de email deve ser válido!")
    String email
) {}
