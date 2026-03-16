package com.sc.empreende.api.mappers;

import org.springframework.stereotype.Component;

import com.sc.empreende.api.dtos.Request.EmpreendimentoCreateDTO;
import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.entities.Empreendimento;

@Component
public class EmpreendimentoMapper {
    public Empreendimento paraEntidade(EmpreendimentoCreateDTO dto) {
        Empreendimento empreendimento = new Empreendimento();

        empreendimento.setNomeEmpreendimento(dto.nomeEmpreendimento());
        empreendimento.setNomeResponsavel(dto.nomeResponsavel());
        empreendimento.setMunicipio(dto.municipio());
        empreendimento.setSegmento(dto.segmento());
        empreendimento.setEmail(dto.email());

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
