package com.sc.empreende.api.mappers;

import org.springframework.stereotype.Component;

import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.entities.Empreendimento;

@Component
public class EmpreendimentoMapper {
    public Empreendimento paraEntidade(EmpreendimentoResponseDTO dto) {
        Empreendimento empreendimento = new Empreendimento();

        empreendimento.setId(dto.id());
        empreendimento.setNomeEmpreendimento(dto.nomeEmpreendimento());
        empreendimento.setNomeResponsavel(dto.nomeResponsavel());
        empreendimento.setMunicipio(dto.municipio());
        empreendimento.setSegmento(dto.segmento());
        empreendimento.setEmail(dto.email());
        empreendimento.setStatus(dto.statusEmpreendimento());

        return empreendimento;
    };

    public EmpreendimentoResponseDTO paraDTO(Empreendimento empreendimento) {
        return new EmpreendimentoResponseDTO(
            empreendimento.getId(),
            empreendimento.getNomeEmpreendimento(),
            empreendimento.getNomeResponsavel(),
            empreendimento.getMunicipio(),
            empreendimento.getSegmento(),
            empreendimento.getEmail(),
            empreendimento.getStatus()
        );
    }
}
