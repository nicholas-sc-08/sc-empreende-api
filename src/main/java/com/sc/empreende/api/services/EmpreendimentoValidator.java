package com.sc.empreende.api.services;

import org.springframework.stereotype.Component;

import com.sc.empreende.api.dtos.Request.EmpreendimentoUpdateDTO;
import com.sc.empreende.api.entities.Empreendimento;
import com.sc.empreende.api.repositories.EmpreendimentoRepository;

import com.sc.empreende.api.exceptions.EmpreendimentoEmailAlreadyExists;
import com.sc.empreende.api.shared.StatusEmpreendimento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpreendimentoValidator {
    private final EmpreendimentoRepository empreendimentoRepository;

    public void validarAtualizacao(Empreendimento empreendimento, EmpreendimentoUpdateDTO dto) {
        if(!empreendimento.getEmail().equals(dto.email())) {
            empreendimentoRepository.findByEmail(dto.email()).ifPresent(e -> { throw new EmpreendimentoEmailAlreadyExists("Empreendimento com o email: "+dto.email()+" já existe!"); });
        }
    }

    public void validarStatusEmpreendimento(Empreendimento empreendimento) {
        if(empreendimento.getStatus().equals(StatusEmpreendimento.ATIVO)) {
            empreendimento.setStatus(StatusEmpreendimento.INATIVO);
        } else {
            empreendimento.setStatus(StatusEmpreendimento.ATIVO);
        }
    }
}
