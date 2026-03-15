package com.sc.empreende.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.entities.Empreendimento;
import com.sc.empreende.api.mappers.EmpreendimentoMapper;
import com.sc.empreende.api.repositories.EmpreendimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpreendimentoService {
    private final EmpreendimentoRepository empreendimentoRepository;
    private final EmpreendimentoMapper empreendimentoMapper;

    public List<EmpreendimentoResponseDTO> findAllEmpreendimentos() {
        List<Empreendimento> empreendimentos = empreendimentoRepository.findAll();
        return empreendimentos.stream().map(e -> empreendimentoMapper.paraDTO(e)).collect(Collectors.toList());
    }
}
