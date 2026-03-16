package com.sc.empreende.api.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sc.empreende.api.dtos.Request.EmpreendimentoCreateDTO;
import com.sc.empreende.api.dtos.Request.EmpreendimentoUpdateDTO;
import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.entities.Empreendimento;
import com.sc.empreende.api.shared.StatusEmpreendimento;

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

    public Empreendimento paraEntidade(EmpreendimentoUpdateDTO dto, UUID id, StatusEmpreendimento status) {
        Empreendimento empreendimento = new Empreendimento();

        empreendimento.setId(id);
        empreendimento.setNomeEmpreendimento(dto.nomeEmpreendimento());
        empreendimento.setNomeResponsavel(dto.nomeResponsavel());
        empreendimento.setMunicipio(dto.municipio());
        empreendimento.setSegmento(dto.segmento());
        empreendimento.setEmail(dto.email());
        empreendimento.setStatus(status);

        return empreendimento;
    }

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
